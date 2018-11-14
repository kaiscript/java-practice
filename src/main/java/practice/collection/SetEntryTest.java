package practice.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaiscript on 2017/3/5.
 */
public class SetEntryTest {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
    }
}
