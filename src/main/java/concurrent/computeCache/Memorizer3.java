package concurrent.computeCache;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by kaiscript on 2017/5/11.
 */
public class Memorizer3<K,V> implements Computable<K,V>{

    private final Map<K, FutureTask<V>> cache = Maps.newConcurrentMap();

    private final Computable computable;

    public Memorizer3(Computable computable) {
        this.computable = computable;
    }

    @Override
    public V compute(K k) throws InterruptedException {
        FutureTask<V> futureTask = cache.get(k);
        if (futureTask == null) {
            Callable<V> vCallable = ()->{
                return (V) computable.compute(k);
            };
            FutureTask<V> ft = new FutureTask<>(vCallable);
            futureTask = ft;
            cache.put(k, ft);
            ft.run();
        }
        try {
            return futureTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


}
