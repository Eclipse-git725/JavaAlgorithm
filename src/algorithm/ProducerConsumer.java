package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 文件名称: ProducerConsumer.java
 * 作者: gxy
 * 创建日期: 2025/4/13
 * 描述: 生产者消费者模式
 */
public class ProducerConsumer {
    private static final int Max_SIZE = 10;
    private final Queue<Integer> buffer = new LinkedList<>();

    public void produce() throws InterruptedException {
        int vaule = 0;
        while (true) {
            synchronized (this) {
                while(buffer.size() == Max_SIZE) {
                    // 队列满，生产者就阻塞
                    wait();
                }
                System.out.println("Producer: " + vaule);
                buffer.add(vaule ++);
                // 唤醒消费者
                notifyAll();
            }
            // 模拟生产时间
            Thread.sleep(1000);
        }

    }

    public void consumer() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while(buffer.isEmpty()) {
                    // 队列空，阻塞消费者
                    wait();
                }
                int value = buffer.poll();
                System.out.println("Consumer: " + value);
                // 唤醒生产者
                notifyAll();
                // 模拟消费时间
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread ProducerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread ConsumerThread = new Thread(() -> {
            try {
                pc.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        ProducerThread.start();
        ConsumerThread.start();
    }
}

