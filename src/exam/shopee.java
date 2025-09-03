package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 文件名称: shopee.java
 * 作者: gxy
 * 创建日期: 2025/9/2
 * 描述: 虾皮笔试
 */
public class shopee {
    public static void main(String[] args) {
        // 二进制字符串相乘，返回二进制字符串
        // 输入10;10，表示字符串10 10
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String[] strs = s.split(";");
        String a = strs[0], b = strs[1];
        Integer num1 = Integer.parseInt(a, 2);
        Integer num2 = Integer.parseInt(b, 2);
        Integer res = num1 * num2;
        System.out.println(Integer.toBinaryString(res));

    }
    public class Solution {
        /**
         * Note: 类名、方法名、参数名已经指定，请勿修改
         *
         *
         *
         * @param cases int整型 ArrayList 每段代码对应的测试用例数目
         * @return int整型
         */
        public int minEffort(ArrayList<Integer> cases) {
            // write code here
            // 合并石子
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int c : cases) {
                pq.add(c);
            }
            int ans = 0;
            while(pq.size() > 1) {
                int a = pq.poll();
                int b = pq.poll();
                ans += a + b;
                pq.add(a + b);
            }
            return ans;
        }

        /**
         * Note: 类名、方法名、参数名已经指定，请勿修改
         *
         *
         *
         * @param k int整型
         * @param w int整型
         * @param profits int整型 一维数组
         * @param capital int整型 一维数组
         * @return int整型
         */
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = profits.length;
            int[][] project = new int[n][2];
            for(int i = 0; i < n; i ++ ) {
                project[i][0] = capital[i];
                project[i][1] = profits[i];
            }
            Arrays.sort(project, (a , b) -> {
                return a[0] - b[0];
            });
            // 大根堆
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                return b - a;
            });

            // 指向第一个节点
            int cur = 0;
            for(int i = 0; i < k; i ++ ) {
                while(cur < n && w >= project[cur][0]) {
                    pq.add(project[cur ++][1]);
                }
                if(pq.isEmpty()) {
                    break;
                }
                int maxProfit = pq.poll();
                w += maxProfit;
            }

            return w;
        }
    }
}
