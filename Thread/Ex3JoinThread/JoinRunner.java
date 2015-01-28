public class JoinRunner {

    static {
        System.out.println("Start Thread Main");
    }

    public static void main(String[] args) {

        JoinThread joinThread1 = new JoinThread("First");
        JoinThread joinThread2 = new JoinThread("Second");

        joinThread1.start();
        joinThread2.start();

        try {
            joinThread1.join(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName());
    }
}
