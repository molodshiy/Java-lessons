public class Car {

    private String name;
    private double price;
    private int year;

    public Car(String name, double price, int year){
        this.name = name;
        this.price = price;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        String s = "Car: " +getName() +" year=" +getYear() +" price =" +getPrice();
        return s;
    }
}
