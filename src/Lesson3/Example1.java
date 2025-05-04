package Lesson3;

import java.io.*;

/**
 * 文件名称: Example1.java
 * 作者: gxy
 * 创建日期: 2025/2/21
 * 描述: 字段不想被序列化时用transient关键字
 */

class Person implements Serializable {
    String name;
    transient int age;  // 使用 transient 修饰字段，表示不进行序列化

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class Example1 {
    public static void main(String[] args) {
        Person person = new Person("John", 30);

        // 序列化
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(person);
            System.out.println("Object serialized: " + person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) in.readObject();
            System.out.println("Object deserialized: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
