package effective.rule51;

/**
 * Created by kaiscript on 2017/3/5.
 */
public class StringTest {

    public static void main(String[] args) {
        String s = "start";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s = s+"hello";
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");

        StringBuilder sb = new StringBuilder();
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append("hello");
        }
        end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");
    }

}
