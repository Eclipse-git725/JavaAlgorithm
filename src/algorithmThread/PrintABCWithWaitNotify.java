package algorithmThread;

/**
 * 文件名称: PrintABCWithWaitNotify.java
 * 作者: gxy
 * 创建日期: 2025/5/2
 * 描述: 多线程交叉打印ABC，使用wait和notify方法
 */
public class PrintABCWithWaitNotify {
    private final Object lock = new Object();
    private int state = 0; // A:0 B:1 C:2

    public static void main(String[] args) {
        PrintABCWithWaitNotify task = new PrintABCWithWaitNotify();
        Thread threadA = new Thread(task::printA);
        Thread threadB = new Thread(task::printB);
        Thread threadC = new Thread(task::printC);

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public void printA() {
        synchronized (lock) {
            for(int i = 0; i < 10; i ++ ) {
                while(state != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("A");
                state = 1;
                lock.notifyAll();
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            for(int i = 0; i < 10; i ++ ) {
                while(state != 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("B");
                state = 2;
                lock.notifyAll();
            }
        }
    }

    public void printC() {
        synchronized (lock) {
            for(int i = 0; i < 10; i ++ ) {
                while(state != 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("C");
                state = 0;
                lock.notifyAll();
            }
        }
    }

}
