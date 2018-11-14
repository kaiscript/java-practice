package concurrent.timeout;

import java.util.concurrent.*;

/**
 * Created by kaiscript on 2018/2/8.
 */
public class TimeoutTest {

    public static void main(String[] args) {
        Future<Integer> future = Executors.newSingleThreadExecutor().submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 1;
            }
        });
        Integer integer = null;
        try {
            integer = future.get(500, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("timeout");
        }
        System.out.println(integer);
    }

}
