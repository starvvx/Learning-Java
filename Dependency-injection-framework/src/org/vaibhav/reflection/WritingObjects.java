package org.vaibhav.reflection;
import org.vaibhav.reflection.BeanManager.BeanManager;
import org.vaibhav.reflection.model.Person;
import org.vaibhav.reflection.orm.EntityManager;
import org.vaibhav.reflection.orm.ManagedEntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class WritingObjects {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        BeanManager beanManager = BeanManager.getInstance();
        EntityManager<Person> entityManager = beanManager.getInstance(ManagedEntityManager.class);

        Person jaljala = entityManager.find(Person.class,1L);
        System.out.println(jaljala);
    }
}
