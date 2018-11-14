package guava;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;

/**
 * Created by kaiscript on 2017/5/26.
 */
public class RangeTest {

    public static void main(String[] args) {
        System.out.println(Range.open(1, 10));
        System.out.println(Range.atLeast(10));
        System.out.println("downTo:"+Range.upTo(4,BoundType.OPEN));
        System.out.println(Range.closed(4,13).hasLowerBound());

        boolean contains = Range.lessThan(new RangeCompartor(5)).contains(new RangeCompartor(6));
        boolean contains1 = Range.greaterThan(new RangeCompartor(1)).contains(new RangeCompartor(4));
        System.out.println(contains);
        System.out.println(contains1);

    }

}
