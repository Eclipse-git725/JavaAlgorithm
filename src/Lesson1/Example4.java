package Lesson1;

/**
 * 文件名称: Example4.java
 * 作者: gxy
 * 创建日期: 2025/2/19
 * 描述: String和StringBuffer 和 StringBuilder 的区别
 */
public class Example4 {
    public static void main(String[] args) {
        // 1. 使用 String
        System.out.println("=== String 操作 ===");
        long startTime = System.nanoTime();
        String str = "Hello";
        str += " World";  // 修改时创建了一个新的 String 对象
        System.out.println(str);  // 输出: Hello World
        long endTime = System.nanoTime();

        // 2. 使用 StringBuffer
        System.out.println("\n=== StringBuffer 操作 ===");
        startTime = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer("Hello");
        sbBuffer.append(" World");  // 直接修改原对象
        System.out.println(sbBuffer);  // 输出: Hello World
        endTime = System.nanoTime();

        // 3. 使用 StringBuilder
        System.out.println("\n=== StringBuilder 操作 ===");
        startTime = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder("Hello");
        sbBuilder.append(" World");  // 直接修改原对象
        System.out.println(sbBuilder);  // 输出: Hello World
        endTime = System.nanoTime();

        // 4. 性能测试：频繁修改字符串
        System.out.println("\n=== 性能测试 ===");
        // 使用 String
        startTime = System.nanoTime();
        String strTest = "";
        for (int i = 0; i < 10000; i++) {
            strTest += "a";  // 每次都会创建一个新的 String 对象
        }
        endTime = System.nanoTime();
        System.out.println("String 性能时间: " + (endTime - startTime) + " 纳秒");

        // 使用 StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbBufferTest = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sbBufferTest.append("a");  // 在原对象上修改
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer 性能时间: " + (endTime - startTime) + " 纳秒");

        // 使用 StringBuilder
        startTime = System.nanoTime();
        StringBuilder sbBuilderTest = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sbBuilderTest.append("a");  // 在原对象上修改
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder 性能时间: " + (endTime - startTime) + " 纳秒");
    }
}
