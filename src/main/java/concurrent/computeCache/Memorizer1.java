package concurrent.computeCache;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 普通的缓存直接加synchronized进行同步
 * Created by kaiscript on 2017/5/11.
 */
public class Memorizer1<K,V> implements Computable<K, V> {

    private final Map<K, V> cache = Maps.newHashMap();

    private final Computable<K, V> computable;

    public Memorizer1(Computable<K, V> computable) {
        this.computable = computable;
    }

    @Override
    public synchronized V compute(K k) throws InterruptedException {
        V result = cache.get(k);
        if (result==null) {
            result = computable.compute(k);
            cache.put(k, result);
        }
        return result;
    }

}
