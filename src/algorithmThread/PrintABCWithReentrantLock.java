package algorithmThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 文件名称: PrintABCWithReentrantLock.java
 * 作者: gxy
 * 创建日期: 2025/5/2
 * 描述: 多线程交叉打印ABC，使用可重入锁和条件变量，比wait和notifyAll更精确的唤醒下一个线程
 */
public class PrintABCWithReentrantLock {
    private final Lock lock = new ReentrantLock();
    // 条件变量代替wait notifyAll
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private int state = 0;

    public static void main(String[] args) {
        PrintABCWithReentrantLock task = new PrintABCWithReentrantLock();
        Thread threadA = new Thread(task::printA);
        Thread threadB = new Thread(task::printB);
        Thread threadC = new Thread(task::printC);

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public void printA() {
        lock.lock();
        try {
            for(int i = 0; i < 10; i ++ ) {
                while(state != 0) {
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("A");
                state = 1;
                conditionB.signal();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock(); // 获取锁
        try {
            for(int i = 0; i < 10; i ++ ) {
                while(state != 1) {
                    try {
                        conditionB.await(); // 不满足条件时等待
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("B");
                state = 2;
                conditionC.signal();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            for(int i = 0; i < 10; i ++ ) {
                while(state != 2) {
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("C");
                state = 0;
                conditionA.signal();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
