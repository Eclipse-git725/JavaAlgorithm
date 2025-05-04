package algorithmThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 文件名称: PrintABCWithCyclicBarrier.java
 * 作者: gxy
 * 创建日期: 2025/5/2
 * 描述: 多线程交叉打印ABC，使用循环栅栏实现
 */
public class PrintABCWithCyclicBarrier {
    // 表示需要三个线程到达屏障点再继续下一轮执行
    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    private int state = 0;
    public static void main(String[] args) {
        PrintABCWithCyclicBarrier task = new PrintABCWithCyclicBarrier();
        Thread threadA = new Thread(task::printA);
        Thread threadB = new Thread(task::printB);
        Thread threadC = new Thread(task::printC);

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public void printA() {
        try {
            for(int i = 0; i < 10; i ++ ) {
                cyclicBarrier.await();
                while(state != 0) {

                }
                System.out.print("A");
                state = 1;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public void printB() {
        try {
            for(int i = 0; i < 10; i ++ ) {
                cyclicBarrier.await();
                while(state != 1) {

                }
                System.out.print("B");
                state = 2;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public void printC() {
        try {
            for(int i = 0; i < 10; i ++ ) {
                cyclicBarrier.await();
                while(state != 2) {

                }
                System.out.println("C");
                state = 0;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
