package Lesson4;

/**
 * 文件名称: Example1.java
 * 作者: gxy
 * 创建日期: 2025/2/25
 * 描述: wait() 作用
 */
public class Example1 {
    private final Object lock = new Object();
    private int product = 0;

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (product > 0) {
                lock.wait();  // 等待消费者消费
            }
            product++;
            System.out.println("Produced: " + product);
            lock.notify();  // 唤醒消费者
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (product == 0) {
                lock.wait();  // 等待生产者生产
            }
            product--;
            System.out.println("Consumed: " + product);
            lock.notify();  // 唤醒生产者
        }
    }
}

