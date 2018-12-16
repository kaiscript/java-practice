package guava.bloom;

import com.google.common.collect.Sets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.lang3.time.StopWatch;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by kaiscript on 2018/12/16.
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(1)
@State(Scope.Thread)
public class BloomJmh {

    BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);

    Set<Integer> set = Sets.newHashSet();

    @Setup
    public void setup() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i <= 10000000; i++) {
            filter.put(i);
        }
        System.out.println(stopWatch.getTime());
        stopWatch.reset();
        stopWatch.start();
        for (int i = 0; i <= 10000000; i++) {
            set.add(i);
        }
        System.out.println(stopWatch.getTime());
        stopWatch.stop();
    }

    public static void main(String[] args) throws Exception{
        Options option = new OptionsBuilder()
                .include(BloomJmh.class.getSimpleName())
                .output("./bloom-vs-set.log")
                .build();
        new Runner(option).run();
    }

    @Benchmark
    public void checkSet() {
        for (int i = 0; i < 100000; i++) {
            set.contains(i);
        }
    }

    @Benchmark
    public void checkBloom() {
        for (int i = 0; i < 100000; i++) {
            filter.mightContain(i);
        }
    }

}
