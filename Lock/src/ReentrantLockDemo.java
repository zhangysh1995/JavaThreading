import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhanysh1995 on 2017/4/12.
 */
public class ReentrantLockDemo {
    public static void main (String [] args) {
        final Count ct = new Count();
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

class Count {
    final ReentrantLock lock = new ReentrantLock();
    public void get() {

     try {
         lock.lock();
         System.out.println(Thread.currentThread().getName() + "get begin");
         Thread.sleep(1000L);
         System.out.println(Thread.currentThread().getName() + "get end");
         lock.unlock();
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
    }

    public void put() {
//        final ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "put begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "put end");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}