import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> products = new ArrayList<>();
        products.add(1);products.add(2);products.add(3);products.add(4);
        products.add(1);products.add(2);products.add(3);products.add(4);
        List<Integer> product = products
                .stream()
                .filter(inti -> inti< 3)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(product);
    }

}
