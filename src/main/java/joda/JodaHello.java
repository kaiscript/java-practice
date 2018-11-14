package joda;

import org.joda.time.LocalTime;

/**
 * Created by kaiscript on 2017/5/8.
 */
public class JodaHello {

    public static void main(String[] args) {
        String str = "12:12:13";
        String[] split = str.split(":");
        LocalTime localTime = new LocalTime(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));
        System.out.println(localTime.toDateTimeToday().toString());
    }

}
