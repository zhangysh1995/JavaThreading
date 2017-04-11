import java.util.concurrent.FutureTask;

/**
 * Created by zhanysh1995 on 2017/4/10.
 */
public class ThreadMain {
    public static void main (String [] args) {
        try {
            // thread
            ThreadA threada = new ThreadA();
            // thread a will exit after all other front-end threads end
            threada.setDaemon(true);

            // runnable
            Thread threadb = new Thread(new ThreadB());
            threadb.run();
            threada.start();

            // callable
            ThreadC threadc = new ThreadC();
            FutureTask<String> feature =new FutureTask<String>(threadc);

            Thread threadC = new Thread(feature);
            threadC.join();
            threadC.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("This is main thread");
    }
}
