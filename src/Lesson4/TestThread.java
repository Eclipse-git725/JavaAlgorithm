package Lesson4;

public class TestThread {
    public static void main(String[] args) {
        Example2 thread = new Example2();

        // 1. 调用 start() 方法
        thread.start();  // 新线程会启动，并执行 run() 方法

        // 2. 直接调用 run() 方法
        thread.run();    // 这会在主线程中调用 run() 方法，不会启动新线程
    }
}
