public class MainThread {
    public static void main(String[] args){

        new ExceptionThread().start();

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" The MainThread works!!!");

    }
}
