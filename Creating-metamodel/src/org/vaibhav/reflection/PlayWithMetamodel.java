package org.vaibhav.reflection;
import org.vaibhav.reflection.model.Person;
import org.vaibhav.reflection.util.ColumnField;
import org.vaibhav.reflection.util.Metamodel;
import org.vaibhav.reflection.util.PrimaryKeyField;

import java.util.*;

public class PlayWithMetamodel {

    public static void main(String[] args) {

//        Metamodel metamodel = Metamodel.of(Person.class);
        Metamodel metamodel = new Metamodel(Person.class);
        PrimaryKeyField primaryKeyField = metamodel.getPrimaryKey();
        List<ColumnField> columnFields= metamodel.getColumns();

        System.out.println("primary key name = " + primaryKeyField.getName() +
                ", type = " + primaryKeyField.getType().getSimpleName());

        for(ColumnField columnField: columnFields) {
            System.out.println("Column name = " + columnField.getName() +
                    ", type = " + columnField.getType().getSimpleName());
        }
    }
}
