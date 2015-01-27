import java.util.*;

public class ExHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>(){
            {
                this.put("Table", 3);
                this.put("Chair", 2);
                this.put("Window", 3);
                this.put("Door", 4);
            }
        };

        System.out.println(hm); // {Window=3, Table=3, Chair=2, Door=4}

        hm.put("Chair", 5);
        System.out.println(hm); // {Window=3, Table=3, Chair=5, Door=4}

        System.out.println(hm.get("Window")); //3

        Set<Map.Entry<String, Integer>> hm1 = hm.entrySet();

        Iterator<Map.Entry<String, Integer>> it = hm1.iterator();

        while(it.hasNext()){
            Map.Entry<String, Integer> me = it.next();
            System.out.println(me);
        }

        Set<Integer> set = new HashSet<Integer> (hm.values());
        System.out.println(set);                                //[3, 4, 5]

    }
}
