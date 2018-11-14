package concurrent;

/**
 * Created by kaiscript on 2017/4/26.
 */
public class Point {

    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x:"+x+"...y:"+y;
    }
}
