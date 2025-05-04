package algorithmThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 文件名称: PrintA5B10C15.java
 * 作者: gxy
 * 创建日期: 2025/5/2
 * 描述: 多线程按顺序调用，A->B->C，AA 打印 5 次，BB 打印10 次，CC 打印 15 次，重复 10 次
 */
public class PrintA5B10C15 {
    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();
    private int state = 0;

    public static void main(String[] args) {
        PrintA5B10C15 task = new PrintA5B10C15();
        new Thread(() -> task.print("A", 0, 5)).start();
        new Thread(() -> task.print("B", 1, 10)).start();
        new Thread(() -> task.print("C", 2, 15)).start();
    }

    public void print(String letter, int target, int times) {
        for(int i = 0; i < 10; i ++ ) {
            // 重复十次
            try {
                lock.lock(); // 获取锁
                while(state != target) {
                    if(target == 0) {
                        conditionA.await();
                    }else if(target == 1) {
                        conditionB.await();
                    }else {
                        conditionC.await();
                    }
                }
                for(int j = 0; j < times; j ++ ) {
                    System.out.print(letter);
                }
                if(state == 2) {
                    System.out.println();
                }
                state = (state + 1) % 3;
                if(target == 0) {
                    conditionB.signal();
                }else if(target == 1) {
                    conditionC.signal();
                }else {
                    conditionA.signal();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
