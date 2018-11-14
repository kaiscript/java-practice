package effective.rule50;

/**
 * Created by kaiscript on 2017/3/4.
 */
public class NumTest {

    public static void main(String[] args) {
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (long i = 0;i<Integer.MAX_VALUE;i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");

        long sum1 = 0L;
        start = System.currentTimeMillis();
        for (long i = 0;i<Integer.MAX_VALUE;i++) {
            sum1 += i;
        }
        end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");

    }

}
