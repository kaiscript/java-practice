package funny;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created by kaiscript on 2017/6/9.
 */
public class Test {

    public static void main(String[] args) throws Exception{

        LazyLoadCache<String,String> cache = new LazyLoadCache<>(new LoadTask<String,String>() {
            @Override
            public String load(String key) {
                System.out.println("load...");
//                long l = RandomUtils.nextLong(1, 1000);
                return key;
            }
        }, 10 * 1000);

        for (int i = 0; i < 500; i++) {
            long number = RandomUtils.nextLong(i,1000+i);
            System.out.println(cache.get(String.valueOf(number)));
        }
        Thread.sleep(5 * 1000);

        for (int i = 0; i < 500; i++) {
            long number = RandomUtils.nextLong(i, 1000+i);
            System.out.println(cache.get(String.valueOf(number)));
        }

    }

}
