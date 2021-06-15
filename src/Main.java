import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> products = new ArrayList<>();
        products.add(1);products.add(2);products.add(3);products.add(4);
        products.add(1);products.add(2);products.add(3);products.add(4);

        List<Integer> newProducts = Collections.unmodifiableList(products);

//        newProducts.add(12); will generate an error

        System.out.println(newProducts);
        products.add(12);
//        changes to the original list will get reflected in the unmodifiable list
//        but if the list is not unmodifiable and just a simple copy then these changes will
//        not be seen in the new list and this is true for all the object of collections

        System.out.println(newProducts);

        Map<Integer, String> names = Map.of(1,"one",2,"Two"); // factory method for map.
//        Also this Map.of() method is unmodifiable
    }

}
