package pattern;

/**
 * 最简单的单例模式
 */
public class Singleton {
    private static volatile Singleton instance;
    //私有的构造方法保证不能直接new一个对象出来
    private Singleton(){

    }
    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
}
