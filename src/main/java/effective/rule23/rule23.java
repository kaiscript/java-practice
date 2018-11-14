package effective.rule23;

import java.util.Set;

/**
 * Created by kaiscript on 2017/2/28.
 */
public class rule23 {

    public void test(Set o) {
        if (o instanceof Set) {
            Set<?> s = (Set<?>) o;
        }
    }

}
