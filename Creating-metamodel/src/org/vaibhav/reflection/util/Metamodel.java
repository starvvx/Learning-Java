package org.vaibhav.reflection.util;

import org.vaibhav.reflection.annotation.Column;
import org.vaibhav.reflection.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Metamodel<T> {

    private Class<T> clss;
    public static <T> Metamodel of(Class<T> clss) {
        return new Metamodel<T>(clss);
    }

    public Metamodel(Class<T> clss) {
        this.clss = clss;
    }

    public PrimaryKeyField getPrimaryKey() {
        Field[] fields = clss.getDeclaredFields();
        for(Field field:fields) {

            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            if(primaryKey != null) {
                PrimaryKeyField primaryKeyField = new PrimaryKeyField(field);
                return primaryKeyField;
            }
        }
        throw new IllegalArgumentException("No primary key found in class" +
                clss.getSimpleName());
    }

    public List<ColumnField> getColumns() {

        List<ColumnField> columnFields = new ArrayList<>();
        Field[] fields = clss.getDeclaredFields();
        for(Field field:fields) {

            Column column = field.getAnnotation(Column.class);
            if(column != null) {
                ColumnField columnField = new ColumnField(field);
                columnFields.add(columnField);
            }
        }
        return columnFields;
    }

    public String buildInsertRequest() {
        String columnElement = buildColumnNames();
        String questionMarksElements = buildQuestionMarksElement();
        return "insert into " + this.clss.getSimpleName() +
                " (" +  columnElement + ") values (" + questionMarksElements + ")";
    }

    public String buildColumnNames() {
        String primaryKeyColumnName = getPrimaryKey().getName();
        List<String> columnNames =
                getColumns().stream().
                        map(ColumnField::getName).
                        collect(Collectors.toList());
        columnNames.add(0,primaryKeyColumnName);
        String columnElement = String.join(", ",columnNames);
        return columnElement;
    }

    public String buildQuestionMarksElement() {
        int numberOfColumns = getColumns().size()+1;
        String questionMarksElements =
                IntStream.range(0,numberOfColumns)
                        .mapToObj(index -> "?")
                        .collect(Collectors.joining(", "));
        return questionMarksElements;
    }
}
