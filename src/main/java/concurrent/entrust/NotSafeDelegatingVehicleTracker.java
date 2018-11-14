package concurrent.entrust;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by kaiscript on 2018/7/8.
 */
public class NotSafeDelegatingVehicleTracker {
    private final ConcurrentMap<String, MutablePoint> locations;
    private final Map<String, MutablePoint> unmodifiableMap;

    public NotSafeDelegatingVehicleTracker(Map<String, MutablePoint> points) {
        locations = new ConcurrentHashMap<String, MutablePoint>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, MutablePoint> getLocations() {
        return unmodifiableMap;
    }

    public Map<String,MutablePoint> getQianLocations() {
        return Collections.unmodifiableMap(new HashMap<>(locations));
    }

    public MutablePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        locations.put(id, new MutablePoint(x, y));
//        if (locations.replace(id, new Point(x, y)) == null)
//            throw new IllegalArgumentException("invalid vehicle name: " + id);
    }
}