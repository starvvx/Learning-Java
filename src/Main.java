
import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;
import java.util.logging.Formatter;

class temp {
    private int x;
    temp(int x) {
        this.x = x;
    }
}


public class Main {
    public static void main(String[] args) {
        temp t = new temp(5);
        Class<?> c = t.getClass();
//        doWork(t);
        Field declaredField[] = c.getDeclaredFields();
        for(Field field:declaredField) {
            System.out.println(field.getName() + " " + field.getType());
        }
    }
    public static void doWork(Object obj) {
        Class<?> c = obj.getClass();
        showName(c);
    }
    public static void showName(Class<?> theClass) {
        System.out.println(theClass.getSimpleName());
    }
};