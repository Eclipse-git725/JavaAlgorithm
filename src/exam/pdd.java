package exam;

import java.util.*;

/**
 * 文件名称: pdd.java
 * 作者: gxy
 * 创建日期: 2025/9/14
 * 描述: pdd 笔试
 */
public class pdd {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        char[] chs = s.toCharArray();
//        StringBuilder ans = new StringBuilder();
//        ans.append(chs[0]).append(chs[1]);
//        int n = s.length();
//        for(int i = 3; i < n; i += 2 ) {
//            ans.append(chs[i]);
//        }
//        System.out.println(ans.toString());

//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int x = in.nextInt();
//        int[] a = new int[n];
//        int[] b = new int[m];
//        for(int i = 0; i < n; i ++ ) {
//            a[i] = in.nextInt();
//        }
//        for(int i = 0; i < m; i ++ ) {
//            b[i] = in.nextInt();
//        }
//        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> {
//            return p[0] - q[0];
//        });
//        Arrays.sort(b);
//        int i = 0;
//        int ans = 0;
//        for(int j = 0; j < m; j ++ ) {
//            // 把bj发货日期前没有入小根堆的a插入到小根堆
//            while(i <= b[j] - 1) {
//                pq.add(new int[]{a[i], 0});
//                i ++;
//            }
//            // 从小根堆中选择价格最小的，并且发货数没到达x的
//            while(!pq.isEmpty() && pq.peek()[1] >= x) {
//                pq.poll();
//            }
//            if(!pq.isEmpty()) {
//                int[] t = pq.poll();
//                ans += t[0];
//                t[1] ++;
//                if(t[1] < x) {
//                    pq.add(t);
//                }
//            }
//        }
//        System.out.println(ans);

        // 找到平衡水晶片段的数量 20%
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i ++ ) {
            a[i] = in.nextInt();
        }
        long[] s = new long[n + 1];
        s[0] = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(s[0], 1);
        for(int i = 0; i < n; i ++ ) {
            s[i + 1] = s[i] + a[i];

        }
        int ans = 0;
        for(int i = 0; i < n; i ++ ) {
            long target = s[i + 1] - (i + 1);
            ans += map.getOrDefault(target, 0);
            map.put(target, map.getOrDefault(target, 0) + 1);
        }
        System.out.println(ans);

        // 交换数组，求序列最大和 100%
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int q = in.nextInt();
//        int[] a = new int[n];
//        for(int i = 0; i < n; i ++ ) {
//            a[i] = in.nextInt();
//        }
//        Arrays.sort(a);
//        long[] left = new long[n];
//        long[] right = new long[n];
//        left[0] = a[n - 1];
//        for(int i = 1; i < n; i ++ ) {
//            left[i] = left[i - 1] + a[n - i - 1];
//        }
//        right[0] = a[0];
//        for(int i = 1; i < n; i ++ ) {
//            right[i] = right[i - 1] + a[i];
//        }
//        while(q != 0) {
//            q --;
//            int x = in.nextInt();
//            int y = in.nextInt();
//            int s = n / x;
//            int t = n / y;
//            // 求出x，y的最小公倍数
//            int g = gcd(x, y);
//            int num = x / g * y;
//            int num1 = n / num;
//            s -= num1;
//            t -= num1;
//            long ans = 0;
//            if(s >= 1 && t >= 1) {
//                ans = left[s - 1] - right[t - 1];
//            }else if(s < 1 && t >= 1) {
//                ans = -right[t - 1];
//            }else if(s >= 1 && t < 1) {
//                ans = left[s - 1];
//            }
//
//            System.out.println(ans);
//        }
    }
    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
