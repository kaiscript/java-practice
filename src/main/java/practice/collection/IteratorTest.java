package practice.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiscript on 2017/3/5.
 */
public class IteratorTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if ("2".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list);
    }

}
