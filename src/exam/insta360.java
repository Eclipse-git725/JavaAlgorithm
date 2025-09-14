package exam;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件名称: insta360.java
 * 作者: gxy
 * 创建日期: 2025/9/9
 * 描述: 影石笔试
 */
public class insta360 {
    /*
    第一题：签到
    第二题：打家劫舍1
    第三题：最小覆盖子串
     */
    public static void main(String[] args) {
        // 等差数列是三个数组成的子序列，求数组中有多少个等差数列
        int[] nums = new int[]{2, 3, 4, 6, 8, 9, 10};
        Map<Integer, Integer> total = new HashMap<>();

        int n = nums.length;
        for(int i = 0; i < n; i ++ ) {
            total.put(nums[i], total.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0;
        // 枚举等差数列中间点
        for(int i = 1; i < n - 1; i ++ ) {
            Map<Integer, Integer> left = new HashMap<>();
            for(int j = 0; j < i; j ++ ) {
                left.put(nums[j], left.getOrDefault(nums[j], 0) + 1);
            }
            for(int j = 0; j < i; j ++ ) {
                int target = 2 * nums[i] - nums[j];
                ans += total.getOrDefault(target, 0) - left.getOrDefault(target, 0) - (nums[i] == target ? 1 : 0);
            }
        }
        System.out.println(ans);
    }
}
