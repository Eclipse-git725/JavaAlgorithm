package exam;

import java.util.*;

/**
 * 文件名称: xiaohongshu.java
 * 作者: gxy
 * 创建日期: 2025/9/14
 * 描述: 小红书笔试
 */
public class xiaohongshu {
    public static void main(String[] args) {
        // 尽量大的数分配在最高位
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        StringBuilder str = new StringBuilder();
//        int[] counts = new int[n];
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
//            return b - a;
//        });
//        for(int i = 0; i < n; i ++ ) {
//            nums[i] = in.nextInt();
//            str.append(String.valueOf(nums[i]));
//            counts[i] = String.valueOf(nums[i]).length();
//            pq.add(counts[i]);
//        }
//        char[] s = str.toString().toCharArray();
//        Arrays.sort(s);
//        for(int i = 0; i < s.length / 2; i ++ ) {
//            char t = s[i];
//            s[i] = s[s.length - i - 1];
//            s[s.length - i - 1] = t;
//        }
//        int ans = 0;
//        int i = 0;
//        while(!pq.isEmpty() && i < s.length) {
//            int t = pq.poll();
//            if(t > 0) {
//                ans += (s[i] - '0') * Math.pow(10, t - 1);
//                i ++;
//                pq.add(t - 1);
//            }
//        }
//        System.out.println(ans);

//        // 通过45%
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String input = in.nextLine();
        char[] s = input.toCharArray();
        //System.out.println(s.length);
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; i -- ) {
            if(st.isEmpty()) {
                st.push(s[i] - '0');
            }else {
                while(!st.isEmpty() && st.peek() != (s[i] - '0')) {
                    st.pop();
                }
                st.push(s[i] - '0');
            }
        }
        System.out.println(n - st.size());

        // 图论不会
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while(t != 0) {
//            t --;
//            int n = in.nextInt();
//            int x = in.nextInt();
//            int y = in.nextInt();
//            int[][] g = new int[n + 1][n + 1];
//            for(int i = 0; i < n - 1; i ++ ) {
//                int u = in.nextInt();
//                int v = in.nextInt();
//                g[u][v] = 1;
//                g[v][u] = 1;
//            }
//            if(x > y) {
//                System.out.println(n * x);
//                continue;
//            }else {
//                System.out.println((n - 1) * y + x);
//            }
//
//        }
    }
}
