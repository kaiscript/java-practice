package jvm.cms;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * -Xmx32m -Xms16m -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -XX:SurvivorRatio=16 -XX:MaxTenuringThreshold=1
 * Created by kaiscript on 2018/12/15.
 */
public class CMSTest {

    public static void main(String[] args) throws Exception{
        Thread.sleep(10000);
        List<byte[]> list = Lists.newArrayList();
        for (int i = 0; i < 28; i++) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }
        System.out.println(list.size());
        Thread.sleep(10000);
    }

}
