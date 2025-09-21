//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 2013 👎 0


package leetcode.editor.cn;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(solution.reverseBetween(head, 2, 4));
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
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left == right) return head;
            ListNode dummy = new ListNode(-1, head);
            ListNode lnode = dummy; // 反转的前一个节点
            for(int i = 0; i < left - 1; i ++ ) {
                lnode = lnode.next;
            }

            ListNode rnode = lnode.next.next;
            ListNode pre = lnode.next;
            ListNode nxt;
            for(int i = left; i < right; i ++ ) {
                nxt = rnode.next;
                rnode.next = pre;
                pre = rnode;
                rnode = nxt;
            }
            lnode.next.next = rnode;
            lnode.next = pre;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
