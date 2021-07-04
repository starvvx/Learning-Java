package org.vaibhav.reflection.model;

public class Person {

    private String name;

    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Person of(String name, int age) {
        return new Person(name, age);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person [name: " + this.name + ", age: " + this.age + "]";
    }
}
