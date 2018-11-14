package concurrent.shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by kaiscript on 2018/5/7.
 */
public class ShutdownTest {

    public void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(finalI);
                    } catch (InterruptedException e) {
                        System.out.println("error" + finalI);
                    }
                }
            });
        }
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ShutdownTest.class){
                    System.out.println("123");
                    ShutdownTest.class.notify();
                }
            }
        }));
    }

    public static void main(String[] args) throws Exception{
        ShutdownTest shutdownTest = new ShutdownTest();
        shutdownTest.start();
    }

}
