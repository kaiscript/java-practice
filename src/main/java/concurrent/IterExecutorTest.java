package concurrent;

import com.google.common.base.Stopwatch;

import java.util.concurrent.*;

/**
 * Created by kaiscript on 2017/5/18.
 */
public class IterExecutorTest {

    private static ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);

    private static ExecutorService cacheService = Executors.newCachedThreadPool();

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1,
            15, 2, TimeUnit.SECONDS, new LinkedBlockingDeque<>(6));



    public static void main(String[] args) throws InterruptedException {
        IterExecutorTest iter = new IterExecutorTest();
//        iter.iter();
        iter.executorService();
    }

    public void executorService() throws InterruptedException {
        Thread.sleep(6000);
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 50; i++) {
            service.execute(()->{
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
    }

    public void iter() throws InterruptedException {
        Thread.sleep(6000);
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
    }

}
