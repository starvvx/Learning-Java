package org.vaibhav.reflection.orm;

import org.vaibhav.reflection.model.Person;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EntityManager<T> {

    static <T> AbstractEntityManager<T> of(Class<T> clss) {
        return new H2EntityManager<T>();
    }

    void persist(T t) throws SQLException, IllegalAccessException;

    T find(Class<T> clss, Object primaryKey) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
