package exam;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 * 文件名称: kedaxunfei.java
 * 作者: gxy
 * 创建日期: 2025/8/30
 * 描述: 科大讯飞笔试
 */
public class kedaxunfei {
    public static void main(String[] args){
        char[] chs = new char[]{'a','b', 'c', 'd', 'e', 'f', 'g'};
        // 将chs转为list
        List<Character> list = new ArrayList<>();
        for(char ch : chs) {
            list.add(ch);
        }
        List<Character> subList = list.subList(1,3);
        subList.set(0, "s".charAt(0));
        // 打印list 和 sublist
        System.out.println(list);
        System.out.println(subList);

    }
}
