package algorithmThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 文件名称: Revise.java
 * 作者: gxy
 * 创建日期: 2025/5/11
 * 描述: 复习之前学过的，在这里再写一遍
 */
public class Revise {
//    private static final int threadCount = 5;
//    private static final Lock lock = new ReentrantLock();
//    private static final Condition[] conditions;
//    int count = 1;
//
//    static {
//        conditions = new Condition[threadCount];
//        for(int i = 0; i < threadCount; i ++ ) {
//            conditions[i] = lock.newCondition();
//        }
//    }

    private static final Lock lock = new ReentrantLock();
    private static final Condition[] conditions;
    private static int state = 0;
    static {
        conditions = new Condition[3];
        for(int i = 0; i < 3; i ++ ) {
            conditions[i] = lock.newCondition();
        }
    }


    public static void main(String[] args) {
        Revise revise = new Revise();
        new Thread(() -> revise.printA()).start();
        new Thread(() -> revise.printB()).start();
        new Thread(() -> revise.printC()).start();

//        for(int i = 0; i < 5; i ++ ) {
//            final int id = i;
//            new Thread(() -> revise.printWithNThread(id)).start();
//        }
    }

//    public void printWithNThread(int threadId) {
//        lock.lock();
//        while(count <= 100) {
//            try {
//                while(count % threadCount != threadId) {
//                    conditions[threadId].await();
//                }
//                System.out.println("threadId: " + threadId + " num:" + count ++);
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                conditions[(threadId + 1) % threadCount].signal();
//            }
//        }
//    }

    private void printA() {
        lock.lock();

            try {
                for(int i = 0; i < 10; i ++ ) {
                    while (state != 0) {
                        conditions[0].await();
                    }
                    System.out.print("A");
                    state++;
                    conditions[1].signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

    }
    private void printB() {
        lock.lock();

            try {
                for(int i = 0; i < 10; i ++ ) {
                    while (state != 1) {
                        conditions[1].await();
                    }
                    System.out.print("B");
                    state++;
                    conditions[2].signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

    }
    private void printC() {
        lock.lock();

            try {
                for(int i = 0; i < 10; i ++ ) {
                    while (state != 2) {
                        conditions[2].await();
                    }
                    System.out.println("C");
                    state = 0;
                    conditions[0].signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

}
