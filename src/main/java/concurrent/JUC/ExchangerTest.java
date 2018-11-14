package concurrent.JUC;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * 5-producers,3-consumers
 * Created by kaiscript on 2017/6/4.
 */
public class ExchangerTest {

    static class Producer implements Runnable {

        private volatile List<String> buffer;
        private Exchanger<List<String>> exchanger;

        public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
            this.buffer = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("生产者第"+i+"次提供");
                for (int j = 1; j <= 5; j++) {
                    buffer.add(i + "-" + j);
                }
                System.out.println("生产者装满，等待消费者消费");
                try {
                    exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    static class Comsumer implements Runnable {

        private volatile List<String> buffer;
        private Exchanger<List<String>> exchanger;

        public Comsumer(List<String> buffer, Exchanger<List<String>> exchanger) {
            this.buffer = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {
                    buffer = exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者第" + i + "次获取");
                for (int j = 1; j <= 3; j++) {
                    String s = buffer.get(0);
                    System.out.println("消费者消费"+s);
                }
            }
        }

    }

    public static void main(String[] args) {
        List<String> buffer = Lists.newArrayList();
        Exchanger<List<String>> exchanger = new Exchanger<>();
        new Thread(new Producer(buffer, exchanger)).start();
        new Thread(new Comsumer(buffer, exchanger)).start();
    }

}
