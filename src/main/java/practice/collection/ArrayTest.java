package practice.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kaiscript on 2017/3/5.
 */
public class ArrayTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(2);
        list.add("guan");
        list.add("bao");
        String[] strings = list.toArray(new String[list.size()]);

        List<String> strList = Arrays.asList(strings);
        System.out.println(strList);
//        strList.add("123");
        strings[0] = "12312";
        System.out.println(strList);
    }

}
