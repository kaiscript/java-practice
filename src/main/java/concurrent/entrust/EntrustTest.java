package concurrent.entrust;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by kaiscript on 2018/7/8.
 */
public class EntrustTest {

    public static void main(String[] args) {
        Map<String, Point> map = Maps.newHashMap();
        DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(map);
        Map<String, Point> locations = tracker.getLocations();
        Map<String, Point> qian = tracker.getQianLocations();
        System.out.println(locations);
        System.out.println(qian);
        tracker.setLocation("1", 2, 1);
        System.out.println(locations);
        System.out.println( );
        tracker.setLocation("2", 2, 1);
        System.out.println(locations);
        System.out.println(qian);
    }

}
