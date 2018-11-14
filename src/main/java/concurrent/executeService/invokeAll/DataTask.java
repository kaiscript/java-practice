package concurrent.executeService.invokeAll;

import java.util.concurrent.Callable;

/**
 * Created by kaiscript on 2017/5/13.
 */
public class DataTask implements Callable<Data> {

    private String id;

    public DataTask(String id) {
        this.id = id;
    }

    @Override
    public Data call() {
        System.out.println("doing DataTask " + id);
        try {
            int time = (int) (Math.random()* 10) * 1000;
            System.out.println("task "+id+" will execute " + time + " time");
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("task" +id+" timeout");
        }
        return new Data(Integer.valueOf(id));
    }
}
