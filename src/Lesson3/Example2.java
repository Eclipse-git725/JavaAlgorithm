package Lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 文件名称: Example2.java
 * 作者: gxy
 * 创建日期: 2025/2/21
 * 描述: 24. 获取⽤键盘输⼊常⽤的两种⽅法
 */
public class Example2 {
    public static void main(String[] args) throws IOException {
        // 从键盘读取字符
//        Scanner input = new Scanner(System.in);
//        String s = input.nextLine();
//        input.close();
//        System.out.println("You entered: " + s);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        input.close();
        System.out.println("You entered: " + s);
    }
}
