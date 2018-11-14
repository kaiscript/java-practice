package concurrent.executeService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kaiscript on 2017/9/11.
 */
public class AsnyTest {

    private ExecutorService service = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        AsnyTest test = new AsnyTest();
        String send = test.send();
        System.out.println(send);
    }

    private String send() {
        System.out.println(1111);
        System.out.println(2222);
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(333);
            }
        });
        System.out.println(444);
        return "res";
    }

}
