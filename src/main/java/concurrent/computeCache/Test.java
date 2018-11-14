package concurrent.computeCache;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kaiscript on 2017/5/11.
 */
public class Test {

    private static final int computeNum = 2;
    private static final CountDownLatch countDownLatch = new CountDownLatch(computeNum);
    private static final int mainStopCountDown = 5;

    private static ExpensiveComputeFunction function = new ExpensiveComputeFunction();

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Computable<Integer,Integer> memorizer1 = new Memorizer1<>(function);
        Computable<Integer,Integer> memorizer2 = new Memorizer2<>(function);
        Computable<Integer,Integer> memorizer3 = new Memorizer3<>(function);
        Computable<Integer,Integer> memorizer4 = new Memorizer4<>(function);
//        test.test(memorizer1);
//        test.test(memorizer2);
//        test.test(memorizer3);
        test.test(memorizer4);
    }

    private void test(Computable memorizer) throws InterruptedException {

        System.out.println("start----!");
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable1(memorizer));
        Thread t2 = new Thread(new Runnable2(memorizer));
        t1.start();
        t2.start();
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");
        System.out.println("end-----!");
    }

    class Runnable1 implements Runnable {

        private Computable<Integer, Integer> memorizer;

        Runnable1(Computable<Integer, Integer> memorizer) {
            this.memorizer = memorizer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    memorizer.compute(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            countDownLatch.countDown();
        }

    }

    class Runnable2 implements Runnable {

        private Computable<Integer, Integer> memorizer;

        Runnable2(Computable<Integer, Integer> memorizer) {
            this.memorizer = memorizer;
        }

        @Override
        public void run() {
            for (int i = 100; i > 0; i--) {
                try {
                    memorizer.compute(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            countDownLatch.countDown();
        }

    }


}
