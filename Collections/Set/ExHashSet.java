import java.util.HashSet;

public class ExHashSet {
    public static void main(String[] args) {

        HashSet<Car> cars = new HashSet<Car>();

        cars.add(new Car("BMW", 54444.34, 2012));
        cars.add(new Car("Audi", 63435.65, 2007));
        cars.add(new Car("Mercedes", 66556, 2011));
        cars.add(new Car("Mitsubishi", 49777.56, 2010));

        cars.add(new Car("Toyota", 30000, 2005));
        cars.add(new Car("Toyota", 30000, 2005));

        for (Car car : cars) {
            System.out.println(car +" hashCode=" +car.hashCode());
        }

        System.out.println(cars.add(new Car("Toyota", 300003, 2005)));  //false
        System.out.println(cars.add(new Car("Toyota100", 300004, 2005))); //true

        System.out.println(cars.size()); //6

        cars.clear();

        if(cars.isEmpty()){
            System.out.println("No cars");
        }
        else{
            for (Car car : cars) {
                System.out.println(car +" hashCode=" +car.hashCode());
            }
        }
    }
}
