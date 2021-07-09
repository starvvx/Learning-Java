package org.vaibhav.generics;

import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person vaibhav = new Person("Vaibhav", 22);
        Person ronaldo = new Person("Ronaldo", 36);
        Person messi = new Person("Messi", 34);

        List<Person> footballers = new ArrayList<>();
        footballers.add(vaibhav);
        footballers.add(ronaldo);
        footballers.add(messi);
        Collections.sort(footballers, new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAge(),p2.getAge());
            }
        });
        for(Person footballer:footballers) {
            System.out.println(footballer);
        }
        Person minAge = min(footballers, new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAge(),p2.getAge());
            }
        });

        System.out.println(minAge);

    }

    public static <T> T min(List<T> values, Comparator<T> comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("list is empty");
        }
        T ans = values.get(0);
        for(int i = 1;i<values.size();i++) {
            final T element = values.get(i);

            if(comparator.compare(element,ans) < 0) {
                ans = element;
            }
        }
        return ans;
    }
}
