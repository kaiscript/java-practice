package guava.Cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by kaiscript on 2017/6/7.
 */
public class CacheService {

    private LoadingCache<String,String> cache = CacheBuilder.newBuilder().expireAfterWrite(20, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return key+"load";
                }
            });



    public void init() {
        System.out.println("init...");
        for (int i = 0; i < 10; i++) {
            cache.put(String.valueOf(i),String.valueOf(i));
        }
    }

    public String get(String key) throws ExecutionException {
        return cache.get(key);
    }


}
