import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Collection<Integer> v= new ArrayList<Integer>();
        v.add(10);
        v.add(10);
        v.add(13);

        Iterator<Integer> itr = v.iterator();
        while (itr.hasNext()) {
            int i = itr.next();
            if(i > 10) {
                itr.remove();
            }
        }
        System.out.println(v);
    }

}
