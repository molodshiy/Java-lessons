import java.util.ArrayList;
import java.util.Iterator;

public class ExIterator {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();

        list.add(0, "one");
        list.add(1, "two");
        list.add(2, "three");
        list.add(3, "six");
        list.add(4, "four");
        list.add("ten");

        list.remove(3);
        list.remove("ten");

        Iterator it = list.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }


        System.out.println("The number of elements is: " +list.size());
    }
}
