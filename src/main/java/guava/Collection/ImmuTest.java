package guava.Collection;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;

import java.util.List;

/**
 * Created by kaiscript on 2017/5/27.
 */
public class ImmuTest {

    public static void main(String[] args) {
        List<Person> list = Lists.newArrayList();
        list.add(new Person("11"));
        list.add(new Person("12"));
        ImmutableListMultimap<String,Person> listMultimap = Multimaps.index(list.iterator(), new Function<Person, String>() {
            @Override
            public String apply(Person input) {
                return "11";
            }
        });
        System.out.println(listMultimap.get("11").size());
        System.out.println(listMultimap.size());

    }

}
