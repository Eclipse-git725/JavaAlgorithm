package Lesson2;

/**
 * 文件名称: Example1.java
 * 作者: gxy
 * 创建日期: 2025/2/20
 * 描述: 静态方法不能调用非静态成员
 */
class MyClass {
    int nonStaticVar = 10;  // 非静态成员变量

    public static void staticMethod() {
        // 编译错误：静态方法不能直接访问非静态成员
        // System.out.println(nonStaticVar);  // Error: nonStaticVar cannot be referenced from a static context
    }

    public void instanceMethod() {
        // 可以直接访问非静态成员
        System.out.println(nonStaticVar);  // 输出: 10
    }
}

public class Example1 {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        // 调用静态方法，编译错误
        MyClass.staticMethod();  // 编译错误

        // 调用实例方法，成功
        obj.instanceMethod();  // 输出: 10
    }
}
