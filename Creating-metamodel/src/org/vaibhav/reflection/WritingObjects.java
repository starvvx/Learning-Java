package org.vaibhav.reflection;
import org.vaibhav.reflection.model.Person;
import org.vaibhav.reflection.orm.EntityManager;
import java.sql.SQLException;

public class WritingObjects {

    public static void main(String[] args) throws SQLException, IllegalAccessException{
        EntityManager<Person> entityManager = EntityManager.of(Person.class);
        Person jaljala = new Person("Jaljala",45);
        Person maiiyoor = new Person("Mayur", 18);
        System.out.println(jaljala);
        System.out.println(maiiyoor);
        System.out.println("writing to db");
        entityManager.persist(jaljala);
        entityManager.persist(maiiyoor);
        System.out.println(jaljala);
        System.out.println(maiiyoor);
    }
}
