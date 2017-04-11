/**
 * Created by zhanysh1995 on 2017/4/10.
 */

// could extends only one super class
public class ThreadA extends Thread{
    public void  run() {
        super.run();

        try {
                Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for ( int i = 0; i< 1000; i++){
            System.out.println("This is thread A running "+ i);
        }


    }
}
