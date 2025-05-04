package Lesson4;

/**
 * 文件名称: Example2.java
 * 作者: gxy
 * 创建日期: 2025/2/25
 * 描述: 区别start() 和 run() 方法
 */
public class Example2 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}

