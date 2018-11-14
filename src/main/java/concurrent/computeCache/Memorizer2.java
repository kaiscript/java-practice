package concurrent.computeCache;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * ConcurrentHashMap进行缓存
 * Created by kaiscript on 2017/5/11.
 */
public class Memorizer2<K, V> implements Computable<K, V> {

    private final Map<K, V> cache = Maps.newConcurrentMap();
    private final Computable<K, V> computable;

    public Memorizer2(Computable<K, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(K k) throws InterruptedException {
        V result = cache.get(k);
        if (result == null) {
            result = computable.compute(k);
            cache.put(k, result);
        }
        return result;
    }

}
