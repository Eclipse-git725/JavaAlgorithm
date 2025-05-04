package algorithmThread;

import java.util.concurrent.Semaphore;

/**
 * 文件名称: PrintABCWithSemaphore.java
 * 作者: gxy
 * 创建日期: 2025/5/2
 * 描述: 多线程交叉打印ABC，使用信号量实现
 */
public class PrintABCWithSemaphore {
    private final Semaphore semA = new Semaphore(1);
    private final Semaphore semB = new Semaphore(0);
    private final Semaphore semC = new Semaphore(0);

    public static void main(String[] args) {
        PrintABCWithSemaphore task = new PrintABCWithSemaphore();
        Thread threadA = new Thread(task::printA);
        Thread threadB = new Thread(task::printB);
        Thread threadC = new Thread(task::printC);

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public void printA() {
        try{
            for(int i = 0; i < 10; i ++ ) {
                semA.acquire();
                System.out.print("A");
                semB.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printB() {
        try{
            for(int i = 0; i < 10; i ++ ) {
                semB.acquire();
                System.out.print("B");
                semC.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printC() {
        try{
            for(int i = 0; i < 10; i ++ ) {
                semC.acquire();
                System.out.println("C");
                semA.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
