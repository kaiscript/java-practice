package guava.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 *
 * 10.239: [GC (Allocation Failure) [PSYoungGen: 33280K->2417K(38400K)] 33280K->2425K(125952K), 0.0024182 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 10.282: [GC (Allocation Failure) [PSYoungGen: 35697K->2178K(38400K)] 35705K->2186K(125952K), 0.0016146 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 10.327: [GC (Allocation Failure) [PSYoungGen: 35458K->2082K(38400K)] 35466K->2090K(125952K), 0.0014665 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 10.380: [GC (Allocation Failure) [PSYoungGen: 35362K->2114K(71680K)] 35370K->2122K(159232K), 0.0013859 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 Heap
 PSYoungGen      total 71680K, used 58100K [0x00000000d5f80000, 0x00000000daa80000, 0x0000000100000000)
 eden space 66560K, 84% used [0x00000000d5f80000,0x00000000d962c7a8,0x00000000da080000)
 from space 5120K, 41% used [0x00000000da580000,0x00000000da790868,0x00000000daa80000)
 to   space 5120K, 0% used [0x00000000da080000,0x00000000da080000,0x00000000da580000)
 ParOldGen       total 87552K, used 8K [0x0000000081e00000, 0x0000000087380000, 0x00000000d5f80000)
 object space 87552K, 0% used [0x0000000081e00000,0x0000000081e02000,0x0000000087380000)
 Metaspace       used 3490K, capacity 4728K, committed 4864K, reserved 1056768K
 class space    used 373K, capacity 424K, committed 512K, reserved 1048576K
 * Created by kaiscript on 2018/12/16.
 */
public class BloomFilterTest {

    public static void main(String[] args) throws Exception{
        Thread.sleep(5000);
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 1000000, 0.01);
        for (int i = 0; i <= 1000000; i++) {
            filter.put(i);
        }
        System.out.println(filter.expectedFpp());
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        System.out.println(filter.mightContain(999999));
        Thread.sleep(10000);
    }

}
