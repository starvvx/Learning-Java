package org.vaibhav.reflection.orm;

import org.vaibhav.reflection.util.ColumnField;
import org.vaibhav.reflection.util.Metamodel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractEntityManager<T> implements EntityManager<T> {

    private AtomicLong idGenerator = new AtomicLong(0l);

    @Override
    public void persist(T t) throws SQLException, IllegalAccessException {
        Metamodel metamodel = Metamodel.of(t.getClass());
        String sql = metamodel.buildInsertRequest();
        try(PreparedStatement statement = prepareStatementWith(sql).andParameters(t)) {
            statement.executeUpdate();
        }
    }

    private prepareStatementWrapper prepareStatementWith(String sql) throws SQLException {
        Connection connection = buildConnection();
        PreparedStatement Statement = connection.prepareStatement(sql);
        return new prepareStatementWrapper(Statement);
    }

    public abstract Connection buildConnection() throws SQLException;

    private class prepareStatementWrapper {

        private PreparedStatement statement;

        public prepareStatementWrapper(PreparedStatement statement) {
            this.statement = statement;
        }

        public PreparedStatement andParameters(T t) throws SQLException, IllegalAccessException {
            Metamodel metamodel = Metamodel.of(t.getClass());
            Class<?> primaryKeyType = metamodel.getPrimaryKey().getType();
            if(primaryKeyType == long.class) {
                long id = idGenerator.incrementAndGet();
                statement.setLong(1,id);
                Field field = metamodel.getPrimaryKey().getField();
                field.setAccessible(true);
                field.set(t, id);
            }
            for (int columnIndex = 0;columnIndex < metamodel.getColumns().size();columnIndex++) {
                ColumnField columnField = (ColumnField) metamodel.getColumns().get(columnIndex);
                Class<?> fieldType = columnField.getType();
                Field field = columnField.getField();
                field.setAccessible(true);
                Object value = field.get(t);
                if(fieldType == int.class) {
                    statement.setInt(columnIndex + 2, (int)value);
                } else if(fieldType == String.class) {
                    statement.setString(columnIndex + 2, (String) value);
                }
            }
            return statement;
        }

        public PreparedStatement andPrimaryKey(Object primaryKey) throws SQLException {
            if(primaryKey.getClass() == Long.class) {
                statement.setLong(1, (long) primaryKey);
            }
            return statement;
        }
    }

    @Override
    public T find(Class<T> clss, Object primaryKey) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Metamodel metamodel = Metamodel.of(clss);
        String sql = metamodel.buildSelectRequest();
        try(PreparedStatement statement = prepareStatementWith(sql).andPrimaryKey(primaryKey);
            ResultSet resultSet = statement.executeQuery();) {
            return buildInstanceFrom(clss,resultSet);
        }
    }

    private T buildInstanceFrom(Class<T> clss, ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Metamodel metamodel = Metamodel.of(clss);

        T t = clss.getConstructor().newInstance();
        Field primaryKeyField = metamodel.getPrimaryKey().getField();
        String primaryKeyColumnName = metamodel.getPrimaryKey().getName();
        Class<?> primaryKeyType = metamodel.getPrimaryKey().getType();

        resultSet.next();
        if(primaryKeyType == long.class) {
            long primaryKey = resultSet.getInt(primaryKeyColumnName);
            primaryKeyField.setAccessible(true);
            primaryKeyField.set(t,primaryKey);
        }

        List<ColumnField> columnFields = metamodel.getColumns();
        for(ColumnField columnField: columnFields) {
            Field field = columnField.getField();
            Class<?> columnType = columnField.getType();
            String columnName = columnField.getName();
            field.setAccessible(true);
            if(columnType == int.class) {
                int value = resultSet.getInt(columnName);
                field.set(t,value);
            } else if(columnType == String.class){
                String value = resultSet.getString(columnName);
                field.set(t,value);
            }
        }
        return t;
    }
}
