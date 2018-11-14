package concurrent.entrust;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by kaiscript on 2018/7/8.
 */
public class SafeFinalTest {

    public static void main(String[] args) {
        Map<String, MutablePoint> map = Maps.newHashMap();
        NotSafeDelegatingVehicleTracker tracker = new NotSafeDelegatingVehicleTracker(map);
        tracker.setLocation("1", 1, 1);
        Map<String, MutablePoint> locations = tracker.getLocations();
        MutablePoint mutablePoint = locations.get("1");
        mutablePoint.x = 222;
        System.out.println(locations);

        Map<String, Point> map1 = Maps.newHashMap();
        DelegatingVehicleTracker safeTracker = new DelegatingVehicleTracker(map1);
        safeTracker.setLocation("1", 1, 1);
        Map<String, Point> locations1 = safeTracker.getLocations();
        Point point = locations1.get("1");
//        point.x = 333; //final 不可变，不会逸出，保证了Point的安全发布
        System.out.println(locations);

    }

}
