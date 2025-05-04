package Lesson1;

/**
 * 文件名称: Example3.java
 * 作者: gxy
 * 创建日期: 2025/2/19
 * 描述: 重写（override）示例
 */
class Animal1 {
    // 父类方法
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal1 {
    // 子类重写父类方法
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}


public class Example3 {
    public static void main(String[] args) {
        Animal1 animal = new Animal1();
        animal.sound();  // 调用父类方法

        Dog dog = new Dog();
        dog.sound();     // 调用子类重写的方法
    }
}
