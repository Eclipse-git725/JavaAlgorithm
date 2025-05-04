package Lesson3;

/**
 * 文件名称: Example3.java
 * 作者: gxy
 * 创建日期: 2025/2/21
 * 描述: 26. 深拷贝和浅拷贝
 */

class Individual {
    String name;
    int age;
    Address address;

    Individual(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

public class Example3 {
    public static void main(String[] args) {
        Address address = new Address("Beijing");
        Individual individual1 = new Individual("Tom", 25, address);

        // 浅拷贝
        Individual individual2 = individual1;  // 直接赋值, 两者指向同一对象

        System.out.println(individual1.address.city);  // Output: Beijing
        System.out.println(individual2.address.city);  // Output: Beijing

        // 修改 individual2 的 address
        individual2.address.city = "Shanghai";

        System.out.println(individual1.address.city);  // Output: Shanghai (individual1 和 individual2 共享同一个 address 对象)
    }
}