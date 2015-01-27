import java.util.Comparator;
import java.util.TreeSet;

public class ExTreeSet {
    public static void main(String[] args) {

        Comparator<Car> comp = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };

        TreeSet<Car> cars = new TreeSet<Car>(comp);

        cars.add(new Car("BMW", 54444.34, 2012));
        cars.add(new Car("Audi", 63435.65, 2007));
        cars.add(new Car("Mercedes", 66556, 2011));

        cars.add(new Car("Mitsubishi", 49777.56, 2010));
        cars.add(new Car("Mitsubishi", 49777.56, 2010)); //false

        for (Car car : cars) {
            System.out.println(car);
        }

        System.out.println(cars.first());
        System.out.println(cars.last());

        TreeSet<Car> cars1 = (TreeSet<Car>) cars.subSet(new Car("Audi", 63435.65, 2007), new Car("Mitsubishi", 49777.56, 2010));

        System.out.println("Tye Number of Cars: " +cars1.size()); //3

        cars1.clear();

        System.out.println(cars1.isEmpty()); //true
    }
}
