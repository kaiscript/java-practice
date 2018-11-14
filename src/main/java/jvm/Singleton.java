package jvm;

/**
 * 1. 新建数组会加载元素类LazyHolder；不会初始化元素类
 * 2. 新建数组不会链接元素类LazyHolder；在getInstance(false)时才真正链接和初始化
 * Created by kaiscript on 2018/7/29.
 */
public class Singleton {
    private Singleton() {}
    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
        static {
            System.out.println("LazyHolder.<clinit>");
        }
    }
    public static Object getInstance(boolean flag) {
        if (flag) return new LazyHolder[2];
        return LazyHolder.INSTANCE;
    }
    public static void main(String[] args) {
        getInstance(true);
        System.out.println("----");
        getInstance(false);
    }
}
