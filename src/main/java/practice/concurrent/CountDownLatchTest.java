package practice.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kaiscript on 2017/3/5.
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }
        try {
            startSignal.countDown();
            System.out.println("main doWork");
            doneSignal.await();
            System.out.println("done finish");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
