package effective.rule29;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaiscript on 2017/3/1.
 */
public class Favorities {

    private Map<Class<?>, Object> map = new HashMap<>();

    public <T> void putFavorities(Class<T> type,T instance){
        map.put(type, type.cast(instance));
    }

    public <T> T get(Class<T> type){
        return type.cast(map.get(type));
    }

}
