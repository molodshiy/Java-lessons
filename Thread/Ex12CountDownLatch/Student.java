import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Student extends Thread{

    private Integer idStudent;
    private List<Task> tasks;
    private CountDownLatch countDown;

    public Student(Integer id, int numberTasks){
        this.idStudent = id;
        this.tasks = new ArrayList<Task>(numberTasks);
        this.countDown = new CountDownLatch(numberTasks);
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public CountDownLatch getCountDown() {
        return countDown;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void run(){
        int i = 0;
        for (Task task : tasks) {

            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            task.setAnsver("Ansver # " + ++i);
            System.out.println("Ansver # " +i +" from " +idStudent);
        }

        try {
            countDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float averageMark = 0;
        for (Task task : tasks) {
            averageMark += task.getMark();
        }

        averageMark /= tasks.size();

        System.out.println("Student " +idStudent + "' Average mark = " +averageMark);
    }
}
