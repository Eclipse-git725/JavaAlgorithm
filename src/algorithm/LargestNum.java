package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 文件名称: LargestNum.java
 * 作者: gxy
 * 创建日期: 2025/5/13
 * 描述: 第一道几个数字拼成最大的一个数，单个数字不可拆 分，比如3 13拼成一个最大的数是313
 */
public class LargestNum {
    public static String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));
        if (numStrs[0].equals("0")) {
            return "0";
        }

        // Build the largest number from sorted strings
        StringBuilder largestNumber = new StringBuilder();
        for (String numStr : numStrs) {
            largestNumber.append(numStr);
        }

        return largestNumber.toString();
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums1)); // Output: 9534330

        int[] nums2 = {313, 3, 31};
        System.out.println(largestNumber(nums2)); // Output: 331313

        int[] nums3 = {0, 0, 0};
        System.out.println(largestNumber(nums3)); // Output: 0
    }
}
