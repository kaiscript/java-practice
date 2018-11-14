package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kaiscript on 2017/2/27.
 */
public class Test {

    private static final String[] value = {};

    public static final List<String> publicValue = Collections.unmodifiableList(Arrays.asList(value));

    public static void main(String[] args) {
        String s = "";
        s.equals("123");
    }

}
