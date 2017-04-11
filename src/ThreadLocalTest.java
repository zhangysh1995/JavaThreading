/**
 * Created by zhanysh1995 on 2017/4/11.
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    public ThreadLocal<Integer> getThreadLocal() {
        return seqNum;
    }

    public int getNextNum() {
        seqNum.set(seqNum.get() +1);
        return seqNum.get();
    }

    public static void main(String [] args) {
        ThreadLocalTest slt = new ThreadLocalTest();

        TestClient t1 = new TestClient(slt);
        TestClient t2 = new TestClient(slt);
        TestClient t3 = new TestClient(slt);
        t1.start();
        t2.start();
        t3.start();
    }

    public static class TestClient extends Thread {
        private ThreadLocalTest slt;
        public TestClient(ThreadLocalTest slt) {
            this.slt = slt;
        }

        public void run() {
            for (int i = 0; i < 3; i++){
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> slt[" + slt.getNextNum() + ']');
            }

            slt.getThreadLocal().remove();
        }
    }
}
