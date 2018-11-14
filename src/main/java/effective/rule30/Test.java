package effective.rule30;

import java.util.Arrays;
import java.util.EnumSet;

/**
 * Created by kaiscript on 2017/3/1.
 */
public class Test {

    public static void main(String[] args) {
        double apply = Operation.PLUS.apply(1, 2);
        System.out.println(apply);
        Operation operation = Operation.formString("+");
        System.out.println(operation.apply(2, 8));

        EnumSet<Operation> es = EnumSet.allOf(Operation.class);
        System.out.println(Arrays.toString(es.toArray()));

        test(BasicOperation.class,1,3);
    }

    public static <T extends Enum<T> & OperationInterface> void test(Class<T> op,double x,double y) {
        for (OperationInterface o : op.getEnumConstants()) {
            System.out.println(o.apply(x,y));
        }
    }

}
