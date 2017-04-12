import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * Created by zhanysh1995 on 2017/4/12.
 */
public class ReentrantReadWriteLockDemo {
    public static void main (String [] args) {
        final NewCount ct = new NewCount();
        for ( int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    ct.get();
                }
            }.start();
        }

        for ( int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    ct.put();
                }
            }.start();
        }
    }
}

class NewCount {
//   private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void get() {
        rwl.readLock().lock();
        try {

            System.out.println(Thread.currentThread().getName() + "get begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "get end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
          rwl.readLock().unlock();
        }
    }

    public void put() {
//        final ReentrantLock lock = new ReentrantLock();
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "put begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "put end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwl.writeLock().unlock();
        }
    }
}