import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"one");map.put(2,"two");map.put(3,"three");

        Collection<Integer > ids = map.keySet();
        Collection<String > vals = map.values();

        var entries = map.entrySet();
        System.out.println(map);


    }

}
