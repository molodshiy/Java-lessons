public class Ex1TreeSet {
    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;                                     //<== Mistake; always true;
                //return Integer.compare(o1, o2);             //<== Correct
            }
        };

        TreeSet<Integer> ts = new TreeSet<Integer>(comparator);
        ts.add(1);
        ts.add(2);
        ts.add(1);

        System.out.println(ts); //[1]   method compare return 0; 1=2; 1=5; 1=1; 1=0;

    }
}
