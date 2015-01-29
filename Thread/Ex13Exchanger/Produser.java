public class Produser extends Subject implements Runnable {

    public Produser(String name, Item item) {
        super(name, item);
    }

    @Override
    public void run() {

            try {
                synchronized (item){
                    int producerNumber = this.getItem().getNumber();
                    item = exchanger.exchange(item);

                    if(producerNumber <= item.getNumber()){
                        System.out.println("Producer " +getName() +" raises producing!!!");
                    } else {
                        System.out.println("Producer " +getName() +" reduce producing!!!");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
