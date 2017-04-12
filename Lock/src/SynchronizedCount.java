/**
 * Created by zhanysh1995 on 2017/4/12.
 */
public class SynchronizedCount {
    public int num = 0;
    public synchronized void methodA() {
        try {
            Thread.sleep(51);

        } catch (InterruptedException e ) {
            e.printStackTrace();
        }

        num += 1;
        System.out.println(Thread.currentThread().getName() + "-" + num);
    }

    public void methodB() {
        synchronized (this) {
            try {
                Thread.sleep(51);
            } catch (InterruptedException e) {

            }
            num +=1 ;
            System.out.println(Thread.currentThread().getName() + "-" + num);
        }
    }
}
