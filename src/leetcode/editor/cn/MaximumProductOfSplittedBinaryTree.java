//给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。 
//
// 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [1,2,3,4,5,6]
//输出：110
//解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
// 
//
// 示例 2： 
//
// 
//
// 输入：root = [1,null,2,3,4,null,null,5,6]
//输出：90
//解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
// 
//
// 示例 3： 
//
// 输入：root = [2,3,9,10,7,8,6,5,4,11,1]
//输出：1025
// 
//
// 示例 4： 
//
// 输入：root = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 50000 个节点，且至少有 2 个节点。 
// 每个节点的值在 [1, 10000] 之间。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 129 👎 0


package leetcode.editor.cn;

public class MaximumProductOfSplittedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfSplittedBinaryTree().new Solution();
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
        long ans = 0;
        public int maxProduct(TreeNode root) {
            long sum = dfs(root);
            System.out.println(sum);
            dfs(root, sum);
            return (int)(ans % 1_000_000_007);
        }

        // 以node为根结点的子树和
        long dfs(TreeNode node) {
            if(node == null) {
                return 0;
            }
            long sum = dfs(node.left) + dfs(node.right) + node.val;
            return sum;
        }

        long dfs(TreeNode node, long sum) {
            if(node == null) {
                return 0;
            }

            long leftsum = dfs(node.left, sum);
            long rightsum = dfs(node.right, sum);
            long subsum = leftsum + rightsum + node.val;
            ans = Math.max(ans, Math.max((sum - leftsum) * leftsum, (sum - rightsum) * rightsum));
            //System.out.println("node: " + node.val + " lsum: " + leftsum + " rsum: " + rightsum + " ans: " + ans);
            return subsum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
