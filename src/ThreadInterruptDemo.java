/**
 * Created by zhanysh1995 on 2017/4/11.
 */
public class ThreadInterruptDemo implements Runnable {
    public static void main(String []args)throws Exception {
        Thread thread = new Thread(new ThreadInterruptDemo(), "InterrupteDemo Thread");

        System.out.println("Starting thread");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Interrupting thread");
        thread.interrupt();
        System.out.println("Is thread interrupted: " + thread.isInterrupted());
        Thread.sleep(3000);
        System.out.println("Stopping application");
    }
    public void run(){
        boolean stop = false;
        while (!stop) {
            System.out.println("My thread is running");
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time < 1000));

            // the thread which is interrupted must handle this interrupt
            if (Thread.currentThread().isInterrupted()) break;
//            if ( Thread.interrupted()) break
        }
        System.out.println("My Thread exiting under request...");
    }
}
