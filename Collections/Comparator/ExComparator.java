import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExComparator {
    public static void main(String[] args) {

        ArrayList<Car> car = new ArrayList<Car>(){
            {
                add(new Car("BMW", 54444.34, 2012));
                add(new Car("Audi", 63435.65, 2007));
                add(new Car("Mercedes", 66556, 2011));
                add(new Car("Toyota", 30000, 2005));
            }
        };

        for (Car c : car) {
            System.out.println(c);
        }

        Comparator<Car> comp = new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return Double.compare(c1.getPrice(), c2.getPrice());
            }
        };

        Collections.sort(car, comp);

        System.out.println(car);
    }
}
