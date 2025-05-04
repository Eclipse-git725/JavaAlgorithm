package algorithmThread;

/**
 * 文件名称: PrintOddEvenWithWaitNotify.java
 * 作者: gxy
 * 创建日期: 2025/5/2
 * 描述: 多线程交叉打印奇偶数，使用Wait Notify实现
 */
public class PrintOddEvenWithWaitNotify {
    private final Object lock = new Object();
    private int state = 1;

    public static void main(String[] args) {
        PrintOddEvenWithWaitNotify task = new PrintOddEvenWithWaitNotify();
        Thread printOdd = new Thread(task::printOdd);
        Thread printEven = new Thread(task::printEven);
        printOdd.start();
        printEven.start();
    }

    public void printOdd() {
        synchronized (lock) {
            while(state <= 20) {
                if(state % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    System.out.println(state);
                    state ++;
                    lock.notifyAll();
                }
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            while(state <= 20) {
                if(state % 2 == 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    System.out.println(state);
                    state ++;
                    lock.notifyAll();
                }
            }
        }
    }
}
