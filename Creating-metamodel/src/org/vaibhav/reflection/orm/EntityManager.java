package org.vaibhav.reflection.orm;

import org.vaibhav.reflection.model.Person;

import java.sql.SQLException;

public interface EntityManager<T> {

    static <T> EntityManager<T> of(Class<T> clss) {
        return new EntityManagerImpl<T>();
    }

    void persist(T t) throws SQLException, IllegalAccessException;
}
