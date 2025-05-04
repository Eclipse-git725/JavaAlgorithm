package Lesson5;

/**
 * 文件名称: Example2.java
 * 作者: gxy
 * 创建日期: 2025/2/27
 * 描述: 双重检验锁实现单例模式
 */
public class Example2 {
    // volatile关键字保证了instance在所有线程中同步
    private static volatile Example2 instance;

    // 私有构造函数，避免外部创建实例
    private Example2() {

    }

    // 双重检验锁
    public static Example2 getInstance() {
        // 第一次检验，如果instance为空，才进入同步块，避免不必要的同步
        if(instance == null) {
            synchronized (Example2.class) {
                // 第二次检验，避免多个线程同时进入同步块后重复创建实例，保证只有第一个进入同步块的线程创建实例
                if(instance == null) {
                    instance = new Example2();
                }
            }
        }
        return instance;
    }

}
