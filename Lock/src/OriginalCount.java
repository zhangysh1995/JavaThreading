/**
 * Created by zhanysh1995 on 2017/4/12.
 */
public class OriginalCount {
    public int num = 0;
    public void add() {
        try {
            Thread.sleep(51);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        num += 1;
        System.out.println(Thread.currentThread().getName() + "-" + num);
    }
}
