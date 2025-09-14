package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 文件名称: zhongan.java
 * 作者: gxy
 * 创建日期: 2025/9/10
 * 描述: 众安保险笔试
 */
public class zhongan {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for(int i = 0; i < n; i ++ ) {
//            nums[i] = in.nextInt();
//        }
//        int ans = 0;
//        Arrays.sort(nums);
//        int i = 1;
//        int flag = 1;
//        while(i < n) {
//            if(flag == 1) {
//                if(nums[i] - nums[i - 1] <= 10) {
//                    flag = 2;
//                }else if(nums[i] - nums[i - 1] <= 20) {
//                    ans ++;
//                    flag = 0;
//                }else {
//                    ans ++;
//                    flag = 1;
//                }
//            }else if(flag == 2) {
//                if(nums[i] - nums[i - 2] <= 10) {
//                    ans ++;
//                    flag = 0;
//                }else {
//                    ans ++;
//                    flag = 1;
//                }
//            }else if(flag == 0) {
//                flag = 1;
//            }
//
//            i ++;
//        }
//        if(flag != 0) {
//            ans ++;
//        }
//        System.out.println(ans);
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t != 0) {
            t --;
            int y = in.nextInt();
            int m = in.nextInt();
            int d = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int a1 = in.nextInt();
            int b1 = in.nextInt();
            int c1 = in.nextInt();
            if(b == 2 && c == 29) {
                c = 28;
            }
            // y m d 出生年月 a b c - a1 b1 c1 时间段内过多少次生日
            int ans = 0;
            if(m < b || (m == b && d < c)) {
                y --;
            }
            for(int i = y + 1; i <= a1; i ++ ) {
                if(i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                    if(b == 2 && c == 29) {
                        if(i == a1 && b1 < 2) {

                        }else if(i == a1 && b1 == 2 && c1 < 29) {

                        }else {
                            ans ++;
                        }
                    }else {
                        if(i == a1 && b1 < b) {

                        }else if(i == a1 && b1 == b && c1 < c) {

                        }else {
                            ans ++;
                        }
                    }
                }else {
                    if(b == 2 && c == 29) {

                    }else {
                        if(i == a1 && b1 < b) {

                        }else if(i == a1 && b1 == b && c1 < c) {

                        }else {
                            ans ++;
                        }
                    }
                }
            }
        }

    }

}
