import java.util.concurrent.Callable;

/**
 * Created by zhanysh1995 on 2017/4/10.
 */
public class ThreadC implements Callable<String> {
    public String call() throws Exception {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("This is threab C");

        return "thread B";
    }
}
