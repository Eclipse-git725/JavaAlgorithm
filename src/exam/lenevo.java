package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 文件名称: lenevo.java
 * 作者: gxy
 * 创建日期: 2025/9/21
 * 描述: 联想笔试
 */
public class lenevo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long l = in.nextLong();
        long r = in.nextLong();

        int n = s.length();

        // 预处理：创建一个小的前缀和数组
        // prefixB[i] 表示 s 的前 i 个字符中 'B' 的数量
        int[] prefixB = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixB[i + 1] = prefixB[i] + (s.charAt(i) == 'B' ? 1 : 0);
        }

        // 利用前缀和思想解决问题
        long ans = countB(r, n, prefixB) - countB(l - 1, n, prefixB);
        System.out.println(ans);


        // 回溯构建正方形
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while(t != 0) {
//            t --;
//            int n = in.nextInt();
//            int[] nums = new int[n];
//            int sum = 0;
//            int maxlen = 0;
//            for(int i = 0; i < n; i ++ ) {
//                nums[i] = in.nextInt();
//                sum += nums[i];
//                maxlen = Math.max(maxlen, nums[i]);
//            }
//            Arrays.sort(nums);
//            for(int i = 0; i < n / 2; i ++ ) {
//                int tmp = nums[i];
//                nums[i] = nums[n - i - 1];
//                nums[n - i - 1] = tmp;
//            }
//            if(sum % 4 != 0 || maxlen > sum / 4) {
//                System.out.println("no");
//                continue;
//            }
//            int[] e = new int[4];
//            if(dfs(0, nums, e, sum / 4)) {
//                System.out.println("yes");
//            }else {
//                System.out.println("no");
//            }
//        }
    }
    private static boolean dfs(int index, int[] nums, int[] e, int target) {
        if(index == nums.length) return true;
        for(int i = 0; i < 4; i ++ ) {
            if(e[i] + nums[index] > target) {
                continue;
            }
            e[i] += nums[index];
            if(dfs(index + 1, nums, e, target)) return true;
            e[i] -= nums[index];
        }
        return false;
    }

    private static long countB(long x, int n, int[] prefixB) {
        if (x <= 0) {
            return 0;
        }

        // 1. 计算完整周期的数量
        long numCycles = x / n;

        // 2. 计算完整周期内 'B' 的总数
        // prefixB[n] 就是一个完整周期内 'B' 的数量
        long totalBInCycles = numCycles * prefixB[n];

        // 3. 计算剩余“边角”部分的长度
        int remainingLen = (int)(x % n);

        // 4. 计算“边角”部分 'B' 的数量
        long bInRemainder = prefixB[remainingLen];

        // 5. 返回总和
        return totalBInCycles + bInRemainder;
    }

}
