package algorithm;

/**
 * 文件名称: MultiplyStrings.java
 * 作者: gxy
 * 创建日期: 2025/5/13
 * 描述: 字符串的大整数相乘
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + result[i + j];
                result[i + j] = sum % 10;
                result[i + j + 1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int i = m + n - 1; i >= 0; i--) {
            if (result[i] == 0 && leadingZero) {
                continue;
            }
            leadingZero = false;
            sb.append(result[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println("The product of " + num1 + " and " + num2 + " is: " + multiply(num1, num2)); // Output: 56088

        // Additional test cases
        System.out.println("The product of 0 and 123 is: " + multiply("0", "123")); // Output: 0
        System.out.println("The product of 123 and 0 is: " + multiply("123", "0")); // Output: 0
        System.out.println("The product of 999 and 999 is: " + multiply("999", "999")); // Output: 998001
        System.out.println("The product of 123456789 and 987654321 is: " + multiply("123456789", "987654321")); // Output: 121932631112635269
    }
}




