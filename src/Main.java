
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
    public void calc() {
        x++;
    }
}


public class Main {
    public static void main(String[] args) {
        temp t = new temp(5);
        Class<?> c = t.getClass();
//        doWork(t);
        Method[] methods = c.getMethods();
        for(Method method:methods) {
//            if(method.getDeclaringClass() != Object.class) {
//                System.out.println(method.getName());
//            }
            System.out.println(method.getName());
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