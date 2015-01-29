public class Consumer extends Subject implements Runnable {

    public Consumer(String name, Item item) {
        super(name, item);
    }

    @Override
    public void run() {
        try {
            int requredNumber = item.getNumber();
            item = exchanger.exchange(item);
            if (requredNumber >= item.getNumber()){
                System.out.println("Producer " +getName() +" raises producing!!!");
            } else {
                System.out.println("Producer " +getName() +" reduce producing!!!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
