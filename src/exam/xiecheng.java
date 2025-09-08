package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 文件名称: xiecheng.java
 * 作者: gxy
 * 创建日期: 2025/9/6
 * 描述: 携程笔试
 */
public class xiecheng {
    static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // n,m大于10的5次方，运行超时，通过20%
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        char[] str = s.toCharArray();
        //System.out.println(s);
        for(int i = 0; i < m; i ++ ) {
            String op = in.nextLine();
            int x = Integer.parseInt(op.substring(12, op.length() - 1));
            if(op.charAt(2) == 'L') {
                if (str[x] >= 'a' && str[x] <= 'z') continue;
                str[x] = (char) (str[x] + 32);
            }else {
                if (str[x] >= 'A' && str[x] <= 'Z') continue;
                str[x] = (char) (str[x] - 32);
            }
        }
        //System.out.println((char)('A' + 32));
        String ans = new String(str);
        System.out.println(ans);

        // a, b, c, d 判断 a/b + c/d 是否是十进制整数或有限小数
        // 输出yes no
//        3
//        2 3 1 3
//        3 7 1 13
//        19 79 3 316
        // 19 79 3 316  结果是1/4 是有限小数
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        int b = in.nextInt();
//        int c = in.nextInt();
//        int d = in.nextInt();
//        if(b == 0 || d == 0) {
//            System.out.println("err");
//            return;
//        }
//        if((a * d + b * c) % (b * d) == 0) {
//            System.out.println((a * d + b * c) / (b * d));
//            System.out.println("yes");
//        }
//        else {
//            int up = a * d + b * c;
//            int down = b * d;
//            int g = gcd(up, down);
//            up /= g;
//            down /= g;
//            // down 约分后只含有2和5的质因子
//            if(down % 2 == 0 || down % 5 == 0) {
//                System.out.println("yes");
//            }else {
//                System.out.println("no");
//            }
//        }


//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int t = in.nextInt();
//        while(t != 0) {
//            t --;
//            int n = in.nextInt();
//            int m = in.nextInt();
//            int[] nums = new int[n];
//            for(int i = 0; i < n; i ++ ) {
//                nums[i] = in.nextInt();
//            }
//            int r = n / m;
//            List<List<Integer>> list = new ArrayList<>();
//            for(int i = 0; i < m; i ++ ) {
//                list.add(new ArrayList<>());
//            }
//            for(int i = 0; i < n; i ++ ) {
//                int c = i % m;
//                list.get(c).add(nums[i]);
//            }
//            for(int i = 0; i < m; i ++ ) {
//                Collections.sort(list.get(i));
//            }
//
//            List<Integer> ans = new ArrayList<>();
//            for(int i = 0; i < r; i ++ ) {
//                for(int j = 0; j < m; j ++ ) {
//                    ans.add(list.get(j).get(i));
//                }
//            }
//
//            for(int i = 0; i < ans.size(); i ++) {
//                System.out.print(ans.get(i) + " ");
//            }
//            System.out.println();
//
//        }

    }
}
