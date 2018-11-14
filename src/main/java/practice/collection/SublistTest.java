package practice.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiscript on 2017/3/5.
 */
public class SublistTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        List<Integer> subList = list.subList(0, 5);
        for (Integer integer : subList) {
            System.out.println(integer);
        }
    }

}
