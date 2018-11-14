package concurrent.single;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by kaiscript on 2017/7/1.
 */
public class SingleTest {

    public static void main(String[] args) {
        Executors.newSingleThreadExecutor().submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "212";
            }
        });
    }

}
