//给定一个长度为 n 的链表 head 
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为 n 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
//
// Related Topics 栈 数组 链表 单调栈 👍 362 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        Solution solution = new NextGreaterNodeInLinkedList().new Solution();
        solution.nextLargerNodes(new ListNode(2, new ListNode(7, new ListNode(4, new ListNode(3, new ListNode(5))))));
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
     class Node {
        int index;
        int val;

        Node() {
        }

        Node(int index) {
            this.index = index;
        }

        Node(int index, int val) {
            this.index = index;
            this.val = val;
        }

    }

    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            Deque<Node> stack = new ArrayDeque<>();
            ListNode cur = head;
            int n = 0;
            while(cur != null) {
                cur = cur.next;
                n ++;
            }
            int[] ans = new int[n];
            cur = head;
            int i = 0;
            while (cur != null) {
                if (stack.isEmpty()) {
                    Node node = new Node(i, cur.val);
                    stack.push(node);
                } else {
                    if(!stack.isEmpty())System.out.println(stack.peek().val);
                    while (!stack.isEmpty() && cur.val > stack.peek().val) {
                        Node node = stack.pop();
                        int index = node.index;
                        ans[index] = cur.val;
                    }
                    Node node = new Node(i, cur.val);
                    stack.push(node);
                }
                i ++;
                cur = cur.next;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
