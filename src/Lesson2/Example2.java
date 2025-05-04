package Lesson2;

/**
 * 文件名称: Example2.java
 * 作者: gxy
 * 创建日期: 2025/2/20
 * 描述: equals 和 hashcode
 */

import java.util.HashSet;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
public class Example2 {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("Alice", 30));
        set.add(new Person("Bob", 25));
        set.add(new Person("Alice", 30));  // 重复的对象

        // 输出集合中的元素
        for (Person person : set) {
            System.out.println(person);
        }
    }
}
