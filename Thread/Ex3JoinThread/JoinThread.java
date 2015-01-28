public class JoinThread extends Thread {

    public JoinThread(String name){
        super(name);
    }
    @Override
    public void run(){

        String name = getName();
        long timeout = 0;

        System.out.println("Start Therad " +name);
        try {
            switch(name){
                case "First":
                    timeout = 5_000;
                    break;
                case "Second":
                    timeout = 1_000;
                    break;
            }
            Thread.sleep(timeout);
            System.out.println("Finish " +name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
