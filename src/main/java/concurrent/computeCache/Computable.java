package concurrent.computeCache;

/**
 * Created by kaiscript on 2017/5/11.
 */
public interface Computable<K,V> {

    V compute(K k) throws InterruptedException;

}
