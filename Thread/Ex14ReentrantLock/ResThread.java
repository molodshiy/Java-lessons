import java.util.Random;

public class ResThread extends Thread {

    private DoubleResource resourse;

    public ResThread(String name, DoubleResource resourse) {
        super(name);
        this.resourse = resourse;
    }

    public void run(){
        for (int i = 0; i < 4; i++) {
            if(new Random().nextInt(2) > 0){
                resourse.adding(getName(), i);
            } else {
                resourse.deleting();
            }
        }
    }
}
