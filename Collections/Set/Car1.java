public class Car1 {
    
    /* This class has override methods equels and hashCode for HashSet*/
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car1 = (Car) o;

        if (name != null ? !name.equals(car1.name)  : car1.name != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? (name +price +year).hashCode() : 0;
    }
}
