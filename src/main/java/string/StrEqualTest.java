package string;

/**
 * Created by kaiscript on 2018/12/16.
 */
public class StrEqualTest {

    public static void main(String[] args) {
        String s1 = new StringBuilder("go").toString();
        String intern = s1.intern();
        System.out.println(intern == s1);

        //java是保留字，在jvm启动时就已经放入字符串常量池中，所以s2是分配在堆中的，s2.intern是指向常量池的，两者的地址不相同false
        String s2 = new StringBuilder("ja").append("va").toString();
        String intern1 = s2.intern();
        System.out.println(intern1 == s2);
    }

}
