package guava.Cache;

/**
 * Created by kaiscript on 2017/6/7.
 */
public class CacheTest {


    public static void main(String[] args) throws Exception{
        CacheService cacheService = new CacheService();
        cacheService.init();
        Thread.sleep(10 * 1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(cacheService.get(String.valueOf(i)));
        }
        Thread.sleep(15 * 1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(cacheService.get(String.valueOf(i)));
        }
    }

}
