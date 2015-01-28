public class SimpleThread extends Thread {
    @Override
    public void run(){

        try {
            if(isDaemon()){
                System.out.println("Thread is daemon");

                Thread.sleep(1);

            } else {
                System.out.println("Tread isn`t daemon");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            if(!isDaemon()){
                System.out.println("Thread finished");
            } else {
                System.out.println("Daemon finished");
            }
        }
    }
}
