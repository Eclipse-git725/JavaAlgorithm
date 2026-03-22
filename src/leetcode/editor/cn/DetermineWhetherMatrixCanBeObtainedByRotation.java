//给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 
//target 一致，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
//输出：true
//解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
// 
//
// 示例 2： 
// 
// 
//输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
//输出：false
//解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
// 
//
// 示例 3： 
// 
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
//输出：true
//解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
// 
//
// 
//
// 提示： 
//
// 
// n == mat.length == target.length 
// n == mat[i].length == target[i].length 
// 1 <= n <= 10 
// mat[i][j] 和 target[i][j] 不是 0 就是 1 
// 
//
// Related Topics 数组 矩阵 👍 43 👎 0


package leetcode.editor.cn;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        Solution solution = new DetermineWhetherMatrixCanBeObtainedByRotation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            int n = mat.length;
            int[][] res;
            if(issame(mat, target)) {
                return true;
            }
            res = rotate(mat);
            if(issame(res, target) == true) {
                return true;
            }
            res = rotate(res);
            if(issame(res, target) == true) {
                return true;
            }
            res = rotate(res);
            if(issame(res, target) == true) {
                return true;
            }
            return false;
        }

        int[][] rotate(int[][] mat) {
            int n = mat.length;
            int[][] res = new int[n][n];
            for(int i = 0; i < n; i ++ ) {
                for(int j = 0; j < n; j ++ ) {
                    res[i][j] = mat[n - j - 1][i];
                }
            }
            return res;
        }

        boolean issame(int[][] a, int[][] b) {
            int n = a.length;
            for(int i = 0; i < n; i ++ ) {
                for(int j = 0; j < n; j ++ ) {
                    if(a[i][j] != b[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
