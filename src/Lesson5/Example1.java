package Lesson5;

/**
 * 文件名称: Example1.java
 * 作者: gxy
 * 创建日期: 2025/2/26
 * 描述: ThreadLocal用法
 */
public class Example1 {
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        Runnable task = () -> {
            Integer value = threadLocalValue.get(); // 获取当前线程的值
            System.out.println("Thread Local Value: " + value);
            threadLocalValue.set(value + 1); // 设置当前线程的新值
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }
}
