package effective.rule66;

import java.util.concurrent.TimeUnit;

/**
 * Created by kaiscript on 2017/3/1.
 */
public class StopThread {

    private static volatile boolean stopRequested = false;
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new r());
        t.start();
        TimeUnit.MILLISECONDS.sleep(1);
        stopRequested = true;
    }

    static class r implements Runnable {

        @Override
        public void run() {
            int i = 0;
            if (!stopRequested) {
                while (true)
                    i++;

            }
            System.out.println(i);
        }
    }


}
