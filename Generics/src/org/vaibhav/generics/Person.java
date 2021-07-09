package org.vaibhav.generics;

import java.util.Comparator;

public final class Person implements Comparator<Person> {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }


    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(),p2.getAge());
    }

    @Override
    public String toString() {
        return "Footballer: [Name: " + this.getName() + " Age: " + this.getAge() + " ]";
    }
}
