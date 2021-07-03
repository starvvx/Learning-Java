package org.vaibhav.reflection.model;

import org.vaibhav.reflection.annotation.Column;
import org.vaibhav.reflection.annotation.PrimaryKey;

public class Person {

    @PrimaryKey(name = "k_id")
    private long id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_age")
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
    public long getId() {
        return this.id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", name: " + this.name + ", age: " + this.age;
    }
}
