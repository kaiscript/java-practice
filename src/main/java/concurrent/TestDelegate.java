package concurrent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaiscript on 2017/4/26.
 */
public class TestDelegate {

    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        Point p3 = new Point(3,3);
        Point p4 = new Point(4,4);
        Point p5 = new Point(5,5);

        Map<String,Point> points = new HashMap<String,Point>();

        points.put("1", p1);
        points.put("2", p2);
        points.put("3", p3);
        points.put("4", p4);
        points.put("5", p5);

        DelegatingVehicleTracker delegateTracker = new DelegatingVehicleTracker(points);

        delegateTracker.setLocation("2", 99, 99);
        delegateTracker.setLocation("3", 33, 33);
        Map<String,Point> result = delegateTracker.getLocations();

        for(String key:result.keySet())
        {
            Point point = result.get(key);
            System.out.println(point);
        }
        System.out.println("-----------------------------------------");


        //test2 - DelegateTrackerF Static
        Point f1 = new Point(1,1);
        Point f2 = new Point(2,2);
        Point f3 = new Point(3,3);
        Point f4 = new Point(4,4);
        Point f5 = new Point(5,5);

        Map<String,Point> points2 = new HashMap<String,Point>();

        points2.put("1", f1);
        points2.put("2", f2);
        points2.put("3", f3);
        points2.put("4", f4);
        points2.put("5", f5);

        DelegatingVehicleTracker delegateTrackerFixedPoint = new DelegatingVehicleTracker(points2);

        delegateTrackerFixedPoint.setLocation("2", 99, 99);
        Map<String,Point> result2 = delegateTrackerFixedPoint.getLocationsAsStatic();
        delegateTrackerFixedPoint.setLocation("3", 33, 33);
        for(String key:result2.keySet())
        {
            Point point = result2.get(key);
            System.out.println(point.toString());
        }
    }

}
