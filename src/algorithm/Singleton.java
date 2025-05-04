package algorithm;

/**
 * 文件名称: Singleton.java
 * 作者: gxy
 * 创建日期: 2025/4/12
 * 描述: 三种方法实现单例模式
 */
// 饿汉式单例模式，在类加载时就初始化，优点实现简单，无并发问题；不使用时，也会占用空间
//public class Singleton {
//    private static final Singleton INSTANCE = new Singleton();
//    private Singleton() {};
//
//    public static Singleton getInstance() {
//        return INSTANCE;
//    }
//}
// 懒汉式单例模式，在初次用时创建，缺点：每次使用时都要先同步，浪费时间
//public class Singleton {
//    private static Singleton instance;
//    private Singleton() {};
//    public static synchronized Singleton getInstance() {
//        if(instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}
// 双重检查锁
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {};

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
