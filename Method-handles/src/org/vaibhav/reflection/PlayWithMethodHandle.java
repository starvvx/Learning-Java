package org.vaibhav.reflection;

import org.vaibhav.reflection.model.Person;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class PlayWithMethodHandle {
    public static void main(String[] args) throws Throwable{

        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType emptyConstructorMethodtype = MethodType.methodType(void.class);
        MethodHandle emptyConstructor = lookup.findConstructor(Person.class, emptyConstructorMethodtype);

        Person p = (Person) emptyConstructor.invoke();
        System.out.println(p);

        MethodType ConstructorMethodtype = MethodType.methodType(void.class,String.class,int.class);
        MethodHandle Constructor = lookup.findConstructor(Person.class, ConstructorMethodtype);

        Person p1 = (Person) Constructor.invoke("Vaibhav",22);
        System.out.println(p1);

        MethodType nameGetterMethodType = MethodType.methodType(String.class);
        MethodHandle nameGetter = lookup.findVirtual(Person.class, "getName",nameGetterMethodType);

        String name = (String) nameGetter.invoke(p1);
        System.out.println(name);

        MethodType nameSetterMethodType = MethodType.methodType(void.class,String.class);
        MethodHandle nameSetter = lookup.findVirtual(Person.class,"setName",nameSetterMethodType);

        nameSetter.invoke(p1,"Verma");
        System.out.println(p1);

//      Code below will give exception
//        MethodHandle nameReader = lookup.findGetter(Person.class,"name",String.class);
//        String name2 = (String) nameReader.invoke(p1);
//        System.out.println(name2);

        MethodHandles.Lookup privateLookup = MethodHandles.privateLookupIn(Person.class,lookup);
        MethodHandle nameReader = privateLookup.findGetter(Person.class,"name",String.class);
        String name2 = (String) nameReader.invoke(p1);
        System.out.println(name2);
    }
}
