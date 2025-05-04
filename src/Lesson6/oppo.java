package Lesson6;

import java.util.HashMap;

/**
 * 文件名称: oppo.java
 * 作者: gxy
 * 创建日期: 2025/4/26
 * 描述: oppo笔试
 */
class MyException extends Exception{

}
class Me {
    void drink(){}
}
class MySon extends Me {
    void eat() throws MyException {}
}

public class oppo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        for(String key : map.keySet()) {
            map.put(key, map.get(key) + 1);
        }
        for(String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
