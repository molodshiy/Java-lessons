import java.util.*;

public class ExTreeMap {
    public static void main(String[] args) {
    
        TreeMap<Car, Integer> tm = new TreeMap<Car, Integer>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        })
        {
            {
                this.put(new Car("BMW", 54444.34, 2012), 545454);
                this.put(new Car("Audi", 63435.65, 2007), 767645);
                this.put(new Car("Mercedes", 66556, 2011), 764532);
                this.put(new Car("Mitsubishi", 49777.56, 2010), 65428);

            }
        };

        System.out.println(tm);

        System.out.println(tm.get(new Car("BMW", 54444.34, 2012))); //545454

        tm.clear();
        System.out.println(tm.isEmpty()); //true
    }
}
