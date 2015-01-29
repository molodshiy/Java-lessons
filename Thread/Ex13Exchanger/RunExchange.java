package UnitThread.Ex13Exchanger;

public class RunExchange {
    public static void main(String[] args) {

        Item item1 = new Item(65, 2000);
        Item item2 = new Item(65, 2100);

        new Thread( new Produser("HP", item1)).start();
        new Thread( new Consumer("Retail Trade", item2)).start();
    }
}
