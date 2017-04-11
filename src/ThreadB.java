/**
 * Created by zhanysh1995 on 2017/4/10.
 */
public class ThreadB implements Runnable {
    public void run() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("This is thread B");
    }
}
