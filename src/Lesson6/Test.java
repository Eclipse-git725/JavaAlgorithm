package Lesson6;

import java.util.*;

/**
 * 文件名称: Test.java
 * 作者: gxy
 * 创建日期: 2025/4/19
 * 描述: 笔试中遇到的程序运行结果题
 */
public class Test {
    public static void sortDigitsBeforeLetters(char[] arr) {
        int n = arr.length;

        for(int i = 1; i < n; i ++ ) {
            char cur = arr[i];
            if(cur >= '0' && cur <= '9') {
                int j = i - 1;
                while(j >= 0 && arr[j] >= 'a' && arr[j] <= 'z') {
                    arr[j + 1] = arr[j];
                    j --;
                }
                arr[j + 1] = cur;
            }
        }

    }

    // 测试代码
    public static void main(String[] args) {
        char[] arr = {'a', '1', 'c', '5', 'b', '9', '2'};
        sortDigitsBeforeLetters(arr);

        for (char c : arr) {
            System.out.print(c + " ");
        }
        // 输出: 1 5 9 2 a c b
    }
}
