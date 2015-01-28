public class MainThread {
    public static void main(String[] args) {

        ThreadHello thread1 = new ThreadHello();
        thread1.start();

        ThreadWorld thread2 = new ThreadWorld();
        thread2.run();

        Thread thread3= new Thread(new ThreadWorld());
        thread3.start();
    }
}
