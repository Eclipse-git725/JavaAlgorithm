package algorithm;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 文件名称: ProducerConsumerWithBolckingQueue.java
 * 作者: gxy
 * 创建日期: 2025/4/13
 * 描述: 用线程安全的阻塞队列实现的生产者消费者模型
 */
public class ProducerConsumerWithBolckingQueue {
    private static final int MAX_SIZE = 10;
    private final BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(MAX_SIZE);

    public void produce() throws InterruptedException {
        int value = 0;
        while(true) {
            buffer.put(value);
            value ++;
            System.out.println("Producer: " + value);
            Thread.sleep(1000); // 模拟生产时间
        }
    }

    public void consumer() throws InterruptedException {
        while(true) {
            int value = buffer.take();
            System.out.println("Consumer: " + value);
            Thread.sleep(1000); // 模拟消费时间
        }
    }

    public static void main(String[] args) {
        ProducerConsumerWithBolckingQueue pc = new ProducerConsumerWithBolckingQueue();
        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumerThread = new Thread(() -> {
            try {
                pc.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
