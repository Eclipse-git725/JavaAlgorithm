package algorithmThread;

import java.util.concurrent.Semaphore;

/**
 * 文件名称: PrintNumberAndLetter.java
 * 作者: gxy
 * 创建日期: 2025/5/2
 * 描述: 两个线程交替打印数字和字母
 */
public class PrintNumberAndLetter {
    private final Semaphore semNum = new Semaphore(1);
    private final Semaphore semLetter = new Semaphore(0);
    int count = 1;
    public static void main(String[] args) {
        PrintNumberAndLetter task = new PrintNumberAndLetter();
        Thread printNum = new Thread(task::printNum);
        Thread printLetter = new Thread(task::printLetter);

        printNum.start();
        printLetter.start();
    }

    public void printNum() {
        try {
            while(count < 26) {
                semNum.acquire();
                System.out.print(count);
                semLetter.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printLetter() {
        try{
            while(count <= 26) {
                semLetter.acquire();
                System.out.print((char)('A' + count - 1));
                count ++;
                semNum.release();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
