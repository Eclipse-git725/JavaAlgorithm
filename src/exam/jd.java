package exam;

import java.util.*;

/**
 * 文件名称: jd.java
 * 作者: gxy
 * 创建日期: 2025/9/20
 * 描述: 京东笔试
 */
public class jd {
    public static void main(String[] args) {
        // n位数字，两个一组，要求组内相同，相邻组不同，求最少改变多少位数能满足条件
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        String input = in.nextLine();
//        char[] nums = input.toCharArray();
//        int g = n / 2;
//        int[][] dp = new int[g][10];
//        for(int j = 0; j < 10; j ++ ) {
//            if(nums[0] == '0' + j && nums[1] == '0' + j) {
//                dp[0][j] = 0;
//            }else if(nums[0] == '0' + j || nums[1] == '0' + j) {
//                dp[0][j] = 1;
//            }else {
//                dp[0][j] = 2;
//            }
//        }
//        int ans = Integer.MAX_VALUE;
//        for(int i = 1; i < g; i ++ ) {
//            int a = Integer.valueOf(nums[2 * i]), b = Integer.valueOf(nums[2 * i + 1]);
//            for(int j = 0; j < 10; j ++ ) {
//                int minv = Integer.MAX_VALUE;
//                for(int k = 0; k < 10; k ++ ) {
//                    if(k != j) {
//                        minv = Math.min(minv, dp[i - 1][k]);
//                    }
//                }
//                if(a == '0' + j && b == '0' + j) {
//                    dp[i][j] = 0;
//                }else if(a == '0' + j || b == '0' + j) {
//                    dp[i][j] = 1;
//                }else {
//                    dp[i][j] = 2;
//                }
//                dp[i][j] += minv;
//                if(i == g - 1) {
//                    ans = Math.min(ans, dp[i][j]);
//                }
//            }
//        }
//        System.out.println(ans);

        // m条双向通行的路线，只能选择海拔向下的，要求最多能到的景点数
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] h = new int[n];
        for(int i = 0; i < n; i ++ ) {
            h[i] = in.nextInt();
        }
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i ++ ) {
            g.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int i = 0; i < m; i ++ ) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            if(h[u] > h[v]) {
                g.get(u).add(v);
                indeg[v] ++;
            }else if(h[v] > h[u]) {
                g.get(v).add(u);
                indeg[u] ++;
            }
        }
        int[] dp = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i ++ ) {
            if(indeg[i] == 0) {
                q.add(i);
            }
            dp[i] = 1;
        }
        int ans = 1;
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int v : g.get(u)) {
                if(dp[v] < dp[u] + 1) {
                    dp[v] = dp[u] + 1;
                    ans = Math.max(ans, dp[v]);
                }
                indeg[v] --;
                if(indeg[v] == 0) {
                    q.add(v);
                }
            }
        }
        System.out.println(ans);
    }
}
