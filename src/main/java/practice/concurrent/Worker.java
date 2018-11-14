package practice.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kaiscript on 2017/3/5.
 */
public class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            System.out.println("work doWork");
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
