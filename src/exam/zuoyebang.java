package exam;

import java.util.Scanner;

/**
 * 文件名称: zuoyebang.java
 * 作者: gxy
 * 创建日期: 2025/9/5
 * 描述: 9/5 作业帮笔试
 */
public class zuoyebang {
    public static void main(String[] args) {
        // 盛水最多的容器
        int n = 3;
        int[] nums = new int[]{3, 3, 2};
        long ans = 0;
        int l = 0, r = n - 1;
        while(l < r) {
            ans = Math.max(ans, (long)(r - l) * Math.min(nums[l], nums[r]));
            if(nums[l] < nums[r]) {
                l ++;
            }else {
                r --;
            }
        }
        System.out.println(ans);
    }

    // 剪绳子
    public int cutRope(int n) {
        // write code here
        if (n == 2) return 1;
        if (n == 3) return 3;
        if (n == 4) return 4;
        int cnt = n / 3;
        int q = n % 3;
        long ans = 1;
        if (q == 1) {
            ans = (long) Math.pow(3, cnt - 1) * 4;
        } else if (q == 2) {
            ans = (long) Math.pow(3, cnt) * 2;
        } else {
            ans = (long) Math.pow(3, cnt);
        }
        return (int) ans;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    int maxNode = Integer.MIN_VALUE;
    int minNode = Integer.MAX_VALUE;
    int maxHeight = 0;
    int minHeight = 0;
    int count = 0; // 叶子节点数量
    // 求二叉树权值最大和最小的叶子节点之间的距离
    public int getDis (TreeNode root) {
        // write code here
        if(root.left == null && root.right == null) {
            return 0;
        }
        getHeight(root, 0);
        if(count == 1) {
            return 0;
        }
        // 找到最大最小节点的公共祖先，答案减去祖先的高度
        TreeNode node = findAncestor(maxNode, minNode, root);
        int height = getHeigth(root, node);
        return maxHeight + minHeight - height * 2;
    }

    int getHeigth(TreeNode root, TreeNode node) {
        if(root == null) {
            return -1;
        }
        if(root == node) {
            return 0;
        }
        int left = getHeigth(root.left, node);
        int right = getHeigth(root.right, node);
        if(left != -1) {
            return left + 1;
        }
        if(right != -1) {
            return right + 1;
        }
        return -1;
    }

    TreeNode findAncestor(int maxNode, int minNode, TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.val == maxNode || root.val == minNode) {
            return root;
        }
        TreeNode left = findAncestor(maxNode, minNode, root.left);
        TreeNode right = findAncestor(maxNode, minNode, root.right);
        if(left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    void getHeight(TreeNode root, int height) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            count ++;
            if(root.val >= maxNode) {
                maxNode = root.val;
                maxHeight = height;
            }
            if(root.val <= minNode) {
                minNode = root.val;
                minHeight = height;
            }
            return ;
        }
        if(root.left != null) {
            getHeight(root.left, height + 1);
        }
        if(root.right != null) {
            getHeight(root.right, height + 1);
        }
    }
}
