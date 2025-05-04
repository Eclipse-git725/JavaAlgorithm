package algorithmThread;

import java.util.concurrent.Semaphore;

/**
 * 文件名称: PrintOddEvenWithSemaphore.java
 * 作者: gxy
 * 创建日期: 2025/5/2
 * 描述: 多线程交叉打印奇偶数，使用信号量实现
 */
public class PrintOddEvenWithSemaphore {
    private final Semaphore semOdd = new Semaphore(1);
    private final Semaphore semEven = new Semaphore(0);
    private int count = 1;

    public static void main(String[] args) {
        PrintOddEvenWithSemaphore task = new PrintOddEvenWithSemaphore();
        Thread printOdd = new Thread(task::pirntOdd);
        Thread printEven = new Thread(task::pirntEven);

        printOdd.start();
        printEven.start();
    }

    public void pirntOdd() {
        while(count <= 100) {
            try {
                if(count % 2 == 0) {
                    semOdd.acquire();
                }else {
                    System.out.println(count);
                    count ++;
                    semEven.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void pirntEven() {
        while(count <= 100) {
            try {
                if(count % 2 == 1) {
                    semEven.acquire();
                }else {
                    System.out.println(count);
                    count ++;
                    semOdd.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
