package joda;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by kaiscript on 2017/10/9.
 */
public class TimeUtil {

    /**
     * 比较时间（无日期）
     */
    public static boolean betweenTimeNoDate(Date begin, Date end,Date date) {
        if (begin == null || end == null) return true;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int h = c.get(Calendar.HOUR_OF_DAY) * 60 + c.get(Calendar.MINUTE);
        c.setTime(begin);
        int h1 = c.get(Calendar.HOUR_OF_DAY) * 60 + c.get(Calendar.MINUTE);
        c.setTime(end);
        int h2 = c.get(Calendar.HOUR_OF_DAY) * 60 + c.get(Calendar.MINUTE);
        if(h1 == h2) return true;
        if (h >= h1 && h <= h2) return true;
        if (h2 < h1 && (h > h1 || h < h2)) {//跨天
            return true;
        }
        return false;
    }

    /**
     * 比较时间（无日期）
     */
    public static boolean betweenTimeNoDate(Date begin, Date end) {
        if (begin == null || end == null) return true;
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR_OF_DAY) * 60 + c.get(Calendar.MINUTE);
        c.setTime(begin);
        int h1 = c.get(Calendar.HOUR_OF_DAY) * 60 + c.get(Calendar.MINUTE);
        c.setTime(end);
        int h2 = c.get(Calendar.HOUR_OF_DAY) * 60 + c.get(Calendar.MINUTE);
        if(h1 == h2) return true;
        if (h >= h1 && h <= h2) return true;
        if (h2 < h1 && (h > h1 || h < h2)) {//跨天
            return true;
        }
        return false;
    }

}
