package concurrent.executeService.invokeAll;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by kaiscript on 2017/5/13.
 */
public class TaskService {

    private final ExecutorService service = Executors.newFixedThreadPool(5);

    public List<Data> execute() {
        List<DataTask> tasks = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            tasks.add(new DataTask(String.valueOf(i)));
        }
        List<Future<Data>> futureList = null;
        try {
            futureList = service.invokeAll(tasks, 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("invokeAll interrupted");
        }

        List<Data> result = Lists.newArrayList();
        for (Future<Data> dataFuture : futureList) {
            Data data = null;
            try {
                data = dataFuture.get();
            } catch (InterruptedException e) {
                System.out.println("timeout");
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (CancellationException e) {
                System.out.println("cancel maybe timeout");
            }
            result.add(data);
        }

        return result;
    }

    public void shutdown() {
        service.shutdown();
    }

}
