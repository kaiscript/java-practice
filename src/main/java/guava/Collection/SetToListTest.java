package guava.Collection;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;
import java.util.Set;

/**
 * Created by kaiscript on 2017/9/10.
 */
public class SetToListTest {

    public static void main(String[] args) {
        Set<String> set = Sets.newHashSet("111","222");
        List<Long> list = Lists.newArrayList(Collections2.transform(set, new Function<String, Long>() {
            @Override
            public Long apply(String input) {
                return NumberUtils.toLong(input);
            }
        }));
        for (Long aLong : list) {
            System.out.println(aLong);
        }
    }

}
