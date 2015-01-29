import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tutor extends Thread {

    private Integer idTutor;
    private List<Student> students;

    public Tutor(){
        this.students = new ArrayList<>();
    }

    public Tutor(List<Student> students){
        this.students = students;
    }

    public Integer getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Integer idTutor) {
        this.idTutor = idTutor;
    }

    public void run (){
        for (Student student : students) {
            List<Task> tasks = student.getTasks();

            for (Task task : tasks) {
                int mark = (3 +new Random().nextInt(7));
                task.setMark(mark);
                System.out.println(mark +" for student N " +student.getIdStudent());
                student.getCountDown().countDown();
            }

            System.out.println("All estimates made for " +student.getIdStudent());
        }
    }
}
