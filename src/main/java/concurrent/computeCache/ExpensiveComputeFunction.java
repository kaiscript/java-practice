package concurrent.computeCache;

/**
 * Created by kaiscript on 2017/5/11.
 */
public class ExpensiveComputeFunction implements Computable<Integer,Integer> {

    @Override
    public Integer compute(Integer integer) throws InterruptedException {
        Thread.sleep(3000);
        return integer;
    }

}
