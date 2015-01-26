import java.util.ArrayList;
import java.util.Iterator;

public class ExArrayList {
    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<Car>();

        Car car = new Car("Mercedes", 66556, 2011);

        cars.add(new Car("BMW", 54444.34, 2012));
        cars.add(new Car("Audi", 63435.65, 2007));
        cars.add(car);
        cars.add(new Car("Toyota", 30000, 2005));

        for (Car c : cars) {
            System.out.println(c);
        }

        System.out.println(cars);

        cars.add(1, new Car("Mitsubishi", 49777.56, 2010));

        for (Car c : cars) {
            System.out.println(c);
        }

        System.out.println("Car(\"Mercedes\", 66556, 2011) has " +cars.indexOf(car) +" place");
        System.out.println("The Number of cars: " +cars.size());
        System.out.println(cars.get(1));


        Iterator i = cars.iterator();
        while(i.hasNext()){
            i.next();
            i.remove();
        }
        System.out.println("Delete all cars:  " +cars.isEmpty());
    }

}
