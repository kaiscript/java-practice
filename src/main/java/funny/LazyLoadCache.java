package funny;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kaiscript on 2017/6/9.
 */
public class LazyLoadCache<T,K> {

    private LoadTask<T,K> loadTask;

    private long expire = 1L;

    private long updateTime;

    private T cache;

    private ReentrantLock lock = new ReentrantLock();

    public LazyLoadCache(LoadTask<T,K> loadTask, long expire) {
        this.loadTask = loadTask;
        this.expire = expire;
    }

    public T get(K k) {
        try {
            boolean b = lock.tryLock();
            if (b) {
                long current = System.currentTimeMillis();
                T load = null;
                if (current - updateTime > expire) {
                    cache = loadTask.load(k);
                    updateTime = System.currentTimeMillis();
                }
                load = cache;
                return load;
            }
        } finally {
            lock.unlock();
        }
        return null;
    }

}
