package exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 文件名称: tuhu.java
 * 作者: gxy
 * 创建日期: 2025/9/4
 * 描述: 途虎养车笔试
 */
public class tuhu {
    public static void main(String[] args) {
//        System.out.println(calc_avg_waiting_time(3, 1, new int[]{1,2,3}, new int[]{3,2,1}));
//        System.out.println(solve(5, new int[]{1, 1, 4, 4, 4}));
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.add(4);
        System.out.println(list.size());
    }
    static String calc_avg_waiting_time (int n, int k, int[] s_i, int[] d_i) {
        // write code here
        double sum = 0;
        double ans;
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; i ++ ) {
            nums[i][0] = s_i[i];
            nums[i][1] = d_i[i];
        }
        Arrays.sort(nums, (a, b) -> {
            return a[0] - b[0];
        });

        // 小根堆，维护结束时间最短的
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int cur = 0;
        if(pq.isEmpty()) {
            for(int i = 0; i < k; i ++ ) {
                if(cur < n) {
                    pq.add(nums[cur][0] + nums[cur][1]);
                    cur ++;
                }
            }
        }
        while(cur < n) {
            int t = pq.poll();
            if(t <= nums[cur][0]) {
                pq.add(nums[cur][0] + nums[cur][1]);
            }else {
                sum += t - nums[cur][0];
                pq.add(t + nums[cur][1]);
            }
            cur ++;
        }
        ans = sum / n;
        return String.format("%.2f", ans);
    }

    static int solve(int time, int[] cars) {
        int n = cars.length;
        // 给cars从大到小排序
        Arrays.sort(cars);
        Collections.reverse(Arrays.asList(cars));
        for(int i = 1; i <= n; i ++ ) {
            if(check(i, time, cars)) {
                return i;
            }
        }
        return 0;
    }
    static boolean check(int m, int time, int[] cars) {
        int[] shifts = new int[m];
        Arrays.fill(shifts, time);
        return dfs(0, cars, shifts);
    }

    static boolean dfs(int i, int[] cars, int[] shifts) {
        if(i == cars.length) {
            return true;
        }
        for(int j = 0; j < shifts.length; j ++ ) {
            if(shifts[j] - cars[i] >= 0) {
                shifts[j] -= cars[i];
                if(dfs(i + 1, cars, shifts)) {
                    return true;
                }
                shifts[j] += cars[i];
            }
        }
        return false;
    }
}
