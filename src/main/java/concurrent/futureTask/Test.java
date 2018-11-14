package concurrent.futureTask;

import java.util.concurrent.ExecutionException;

/**
 * Created by kaiscript on 2017/7/1.
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Render render = new Render();
        render.start();

    }

}
