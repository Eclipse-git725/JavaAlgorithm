package algorithmThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 文件名称: PrintOddEvenWithReentrantLock.java
 * 作者: gxy
 * 创建日期: 2025/5/2
 * 描述: 多线程交叉打印奇偶数，使用可重入锁和条件变量实现
 */
public class PrintOddEvenWithReentrantLock {
    private final Lock lock = new ReentrantLock();
    private final Condition conditionOdd = lock.newCondition();
    private final Condition conditionEven = lock.newCondition();
    private int count = 1;

    public static void main(String[] args) {
        PrintOddEvenWithReentrantLock task = new PrintOddEvenWithReentrantLock();
        Thread printOdd = new Thread(task::pirntOdd);
        Thread printEven = new Thread(task::pirntEven);

        printOdd.start();
        printEven.start();
    }

    public void pirntOdd() {
        lock.lock();
        try {
            while(count <= 100) {
                if(count % 2 == 0) {
                    conditionOdd.await();
                }else {
                    System.out.println(count);
                    count ++;
                    conditionEven.signal();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void pirntEven() {
        lock.lock();
        try {
            while(count <= 100) {
                if(count % 2 == 1) {
                    conditionEven.await();
                }else {
                    System.out.println(count);
                    count ++;
                    conditionOdd.signal();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
