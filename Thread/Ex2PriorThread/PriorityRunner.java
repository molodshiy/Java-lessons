public class PriorityRunner {
    public static void main(String[] args) {

        PriorThread priorThread1 = new PriorThread("Min");
        PriorThread priorThread2 = new PriorThread("Norm");
        PriorThread priorThread3 = new PriorThread("Max");

        priorThread1.setPriority(Thread.MIN_PRIORITY);
        priorThread2.setPriority(Thread.NORM_PRIORITY);
        priorThread3.setPriority(Thread.MAX_PRIORITY);

        priorThread1.start();
        priorThread2.start();
        priorThread3.start();

    }
}
