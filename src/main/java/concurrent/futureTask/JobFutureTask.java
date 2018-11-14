package concurrent.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by kaiscript on 2017/7/1.
 */
class JobFutureTask extends FutureTask{

    public JobFutureTask(Callable callable) {
        super(callable);
    }

}
