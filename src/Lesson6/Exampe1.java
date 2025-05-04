package Lesson6;

import java.util.concurrent.CountDownLatch;

/**
 * 文件名称: Exampe1.java
 * 作者: gxy
 * 创建日期: 2025/2/28
 * 描述: CountDownLatch 例子
 */
public class Exampe1 {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println("子线程" + Thread.currentThread().getName() + "开始执行任务");
                // 模拟任务执行时间
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程" + Thread.currentThread().getName() + "完成任务");
                latch.countDown(); // 计数器减1
            }).start();
        }

        latch.await(); // 主线程等待所有子线程完成任务
        System.out.println("所有子线程完成任务，主线程继续执行");
    }
}
