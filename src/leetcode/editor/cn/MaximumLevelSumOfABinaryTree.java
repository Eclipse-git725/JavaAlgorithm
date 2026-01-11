//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。 
//
// 返回总和 最大 的那一层的层号 x。如果有多层的总和一样大，返回其中 最小 的层号 x。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,7,0,7,-8,null,null]
//输出：2
//解释：
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
// 
//
// 示例 2： 
//
// 
//输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在
// [1, 10⁴]范围内
// 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 153 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumLevelSumOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumLevelSumOfABinaryTree().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int maxLevelSum(TreeNode root) {
            int ans = 0;
            int maxv = Integer.MIN_VALUE;
            Deque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            int f = 0;
            while(!q.isEmpty()) {
                int sum = 0;
                int sz = q.size();
                for(int i = 0; i < sz; i ++ ) {
                    TreeNode t = q.peek();
                    if(t.left != null) {
                        q.add(t.left);
                    }
                    if(t.right != null) {
                        q.add(t.right);
                    }
                    sum += t.val;
                    q.poll();
                }
                f ++;
                if(sum > maxv) {
                    maxv = sum;
                    ans = f;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
