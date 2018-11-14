package concurrent.computeCache;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by kaiscript on 2017/5/11.
 */
public class Memorizer4<K, V> implements Computable<K,V> {

    private final Map<K, Future<V>> cache = Maps.newConcurrentMap();

    private final Computable<K, V> computable;

    public Memorizer4(Computable<K, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(K k) throws InterruptedException {
        while (true) {
            Future<V> future = cache.get(k);
            if (future == null) {
                Callable<V> callable = ()->{
                    return computable.compute(k);
                };
                FutureTask<V> ft = new FutureTask<>(callable);
                future = cache.putIfAbsent(k,ft);
                if (future == null) {
                    future = ft;
                    ft.run();
                }

            }
            try {
                return future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

}
