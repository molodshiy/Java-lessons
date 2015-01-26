import UnitCollection.Car;
import java.util.LinkedList;

public class ExLinkedList {
    public static void main(String[] args) {

        LinkedList<Car> cars = new LinkedList<Car>();

        cars.add(new Car("BMW", 54444.34, 2012));
        cars.addFirst(new Car("Audi", 63435.65, 2007));
        cars.addLast(new Car("Mercedes", 66556, 2011));
        cars.addFirst(new Car("Mitsubishi", 49777.56, 2010));
        cars.offer(new Car("Toyota", 30000, 2005));

        for (Car c : cars) {
            System.out.println(c);
        }

        System.out.println(cars.get(1));
        System.out.println("The Number of cars: " +cars.size());

        cars.removeFirst();
        cars.removeLast();
        
        cars.poll();

        for (Car c : cars) {
            System.out.println(c);
        }

        System.out.println("Delete all cars:  " +cars.isEmpty());
    }
}
