package guava.Collection;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * Created by kaiscript on 2017/4/10.
 */
public class CollectionTest {

    public static void main(String[] args) {
        ImmutableSet<String> of = ImmutableSet.of("ss");

        List<String> list = Lists.newArrayList("123");
        Collection<Long> transform = Collections2.transform(list, (String s) -> Long.valueOf(s));
        for (Long aLong : transform) {
            System.out.println(aLong);
        }
    }

}
