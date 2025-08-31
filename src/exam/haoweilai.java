package exam;

/**
 * 文件名称: haoweilai.java
 * 作者: gxy
 * 创建日期: 2025/5/15
 * 描述: 好未来笔试题选择中的代码运行结果题目复盘
 */
public class haoweilai {
    Base who = new Sub();

    public static void main(String[] args) {
        haoweilai test = new haoweilai();
        System.out.println(test.who.val); // 0
        System.out.println(test.who.staticval); // 0
        test.who.staticMethod(); // Base staticMethod
        test.who.method(); // Sub method

        int parm1 = 0;
        Parameter parm2 = new Parameter();
        Parameter parm3 = new Parameter();
        int[] parm4 = {0};
        test.change(parm1, parm2, parm3, parm4);
    }

    private void change(int parm1, Parameter parm2, Parameter parm3, int[] parm4) {
        parm1 = 1;
        parm2.parameter = 1;
        parm3 = new Parameter();
        parm3.parameter = 1;
        parm4[0] = 1;
        System.out.println(parm1 + " " + parm2.parameter + " " + parm3.parameter + " " + parm4[0]);
    }
}

class Base{
    public int val = 0;
    public static int staticval = 0;
    public static void staticMethod() {
        System.out.println("Base staticMethod");
    }
    public void method() {
        System.out.println("Base method");
    }
}

class Sub extends Base {
    public int val = 1;
    public static int staticval = 1;
    public static void staticMethod() {
        System.out.println("Sub staticMethod");
    }
    public void method() {
        System.out.println("Sub method");
    }
}

class Parameter {
    int parameter = 0;
}