package Lesson1;

// Lesson1/Example1.java
// 2025/2/18
// 知识点：Java不支持多继承，但支持多实现
public class Example1 {
    public static void main(String[] args) {
        // 创建一个 Bird 对象，它继承了 Animal 并实现了 Swimmable 和 Flyable 接口
        Bird bird = new Bird();
        bird.eat();      // 来自 Animal 类
        bird.fly();      // 来自 Flyable 接口
        bird.swim();     // 来自 Swimmable 接口
    }
}

// Animal 类只能继承一个父类（Java 是单继承的）
class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Swimmable 接口，可以多继承
interface Swimmable {
    void swim();  // 抽象方法，不同类可以实现这个方法
}

// Flyable 接口，可以多继承
interface Flyable {
    void fly();  // 抽象方法，不同类可以实现这个方法
}

// Bird 类继承 Animal 类并实现 Swimmable 和 Flyable 接口
class Bird extends Animal implements Swimmable, Flyable {
    // 实现 Swimmable 接口的方法
    @Override
    public void swim() {
        System.out.println("Bird is swimming");
    }

    // 实现 Flyable 接口的方法
    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}