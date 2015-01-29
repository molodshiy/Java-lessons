import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {

        final int NUMBER_TASKS1 = 5;
        Student student1 = new Student(32546, NUMBER_TASKS1);
        for (int i = 0; i < NUMBER_TASKS1; i++) {
            Task task = new Task("Task #" +i);
            student1.addTask(task);
        }

        final int NUMBER_TASKS2 = 4;
        Student student2 = new Student(65432, NUMBER_TASKS2);
        for (int i = 0; i < NUMBER_TASKS2; i++) {
            Task task = new Task("Task ##" +i);
            student2.addTask(task);
        }

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Tutor tutor = new Tutor(students);
        student1.start();
        student2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tutor.start();
    }
}
