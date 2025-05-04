package Lesson1;

/**
 * 文件名称: Example2.java
 * 作者: gxy
 * 创建日期: 2025/2/19
 * 描述: 重载
 */
class Calculator {
    // 加法方法（整数）
    public int add(int a, int b) {
        return a + b;
    }

    // 加法方法（浮点数）
    public double add(double a, double b) {
        return a + b;
    }

    // 加法方法（多个整数）
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Example2 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Add (int, int): " + calc.add(5, 10));         // 调用 add(int, int)
        System.out.println("Add (double, double): " + calc.add(5.5, 10.5)); // 调用 add(double, double)
        System.out.println("Add (int, int, int): " + calc.add(1, 2, 3));    // 调用 add(int, int, int)
    }
}
