package guava;

/**
 * Created by kaiscript on 2017/5/27.
 */
public class RangeCompartor implements Comparable<RangeCompartor>{

    private int version;

    public RangeCompartor(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int compareTo(RangeCompartor o) {
        int version = this.getVersion();
        int version1 = o.getVersion();
        return version-version1;
    }

}
