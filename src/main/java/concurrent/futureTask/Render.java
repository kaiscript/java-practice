package concurrent.futureTask;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kaiscript on 2017/7/1.
 */
public class Render {

    ExecutorService executor = Executors.newSingleThreadExecutor();

    public void start() throws ExecutionException, InterruptedException {

        try {
            Callable callable = new Callable() {
                @Override
                public Object call() throws Exception {
                    Data data = new Data();
                    data.setString("data");
                    Thread.sleep(3000);
                    return data.getString();
                }
            };
            JobFutureTask task = new JobFutureTask(callable);
            executor.submit(task);
            System.out.println(task.get());
        } finally {
            executor.shutdown();
            System.out.println("shutdown");
        }
    }

}
