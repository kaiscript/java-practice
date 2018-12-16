package guava.bloom;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 10.211: [GC (Allocation Failure) [PSYoungGen: 33280K->5096K(38400K)] 33280K->26294K(125952K), 0.0222277 secs] [Times: user=0.11 sys=0.00, real=0.02 secs]
 10.246: [GC (Allocation Failure) [PSYoungGen: 38376K->5096K(38400K)] 59574K->63798K(125952K), 0.0343703 secs] [Times: user=0.20 sys=0.03, real=0.03 secs]
 10.281: [Full GC (Ergonomics) [PSYoungGen: 5096K->0K(38400K)] [ParOldGen: 58702K->55231K(133120K)] 63798K->55231K(171520K), [Metaspace: 3268K->3268K(1056768K)], 0.2698554 secs] [Times: user=1.53 sys=0.00, real=0.27 secs]
 Heap
 PSYoungGen      total 38400K, used 1318K [0x00000000d5f80000, 0x00000000daa80000, 0x0000000100000000)
 eden space 33280K, 3% used [0x00000000d5f80000,0x00000000d60c9a58,0x00000000d8000000)
 from space 5120K, 0% used [0x00000000d8500000,0x00000000d8500000,0x00000000d8a00000)
 to   space 5120K, 0% used [0x00000000d8000000,0x00000000d8000000,0x00000000d8500000)
 ParOldGen       total 133120K, used 55231K [0x0000000081e00000, 0x000000008a000000, 0x00000000d5f80000)
 object space 133120K, 41% used [0x0000000081e00000,0x00000000853efc60,0x000000008a000000)
 Metaspace       used 3274K, capacity 4596K, committed 4864K, reserved 1056768K
 class space    used 356K, capacity 424K, committed 512K, reserved 1048576K
 * Created by kaiscript on 2018/12/16.
 */
public class SetTest {

    public static void main(String[] args) throws Exception{
        Thread.sleep(5000);
        Set<Integer> set = Sets.newHashSet();
        for (int i = 0; i < 1000000; i++) {
            set.add(i);
        }
        Thread.sleep(10000);
    }

}
