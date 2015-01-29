import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ChanelPool <T> {

    private static final int POOL_SIZE = 5;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Queue<T> resources = new LinkedList<T>();

    public ChanelPool(Queue<T> soure) {
        resources.addAll(soure);
    }

    public T getResources(long maxWaitMillis) throws ResourceException {
        try {
            if(semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)){
                T res = resources.poll();
                return res;
            }
        } catch (InterruptedException e) {
            throw new ResourceException(e);
        }
        throw new ResourceException("TimeWait ended");
    }

    public void returnResourse(T res){
        resources.add(res);
        semaphore.release();
    }
}
