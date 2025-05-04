package algorithmThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 文件名称: PrintOddEvenWithNThread.java
 * 作者: gxy
 * 创建日期: 2025/5/2
 * 描述: 使用N个线程打印1-100
 */
public class PrintOddEvenWithNThread {
    private static final int ThreadCount = 5;
    private static final Lock lock = new ReentrantLock();
    private static final Condition[] conditions;
    int count = 1;

    static {
        conditions = new Condition[ThreadCount];
        for(int i = 0; i < ThreadCount; i ++ ) {
            conditions[i] = lock.newCondition();
        }
    }

    public static void main(String[] args) {
        PrintOddEvenWithNThread task = new PrintOddEvenWithNThread();
        for(int i = 0; i < ThreadCount; i ++ ) {
            final int id = i;
            new Thread(() -> task.print(id)).start();
        }
    }

    public void print(int threadId) {
        while(count <= 100) {
            lock.lock();
            try {
                while(count % ThreadCount != threadId) {
                    conditions[threadId].await();
                }
                if(count <= 100) {
                    System.out.println("ThreadId: " + threadId + " num:" + count);
                }
                count ++;
                conditions[(threadId + 1) % ThreadCount].signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
