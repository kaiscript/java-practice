package concurrent.executeService.completionService;

import java.util.concurrent.*;

/**
 * Created by kaiscript on 2017/5/13.
 */
public class CompletionService {

    private BlockingQueue<Future<InfoData>> blockingQueue = new ArrayBlockingQueue<>(100);

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void submit(Callable<InfoData> callable) {
        Future<InfoData> future = executorService.submit(callable);
        blockingQueue.add(future);
    }

    public Future<InfoData> take() throws InterruptedException {
        return blockingQueue.take();
    }

    public void shutdown() {
        executorService.shutdown();
    }

}
