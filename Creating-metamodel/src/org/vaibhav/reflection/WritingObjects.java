package org.vaibhav.reflection;

import org.vaibhav.reflection.model.Person;
import org.vaibhav.reflection.orm.EntityManager;

import java.sql.SQLException;

public class WritingObjects {

    public static void main(String[] args) throws SQLException, IllegalAccessException {

        EntityManager<Person> entityManager = EntityManager.of(Person.class);

        Person linda = new Person("Linda",31);
        Person james = new Person("James",24);
        Person susan = new Person("Susan",34);
        Person john = new Person("John",33);

        System.out.println(linda);
        System.out.println(susan);
        System.out.println(james);
        System.out.println(john);

        System.out.println("Writing to db");

        entityManager.persist(linda);
        entityManager.persist(susan);
        entityManager.persist(james);
        entityManager.persist(john);



    }
}
