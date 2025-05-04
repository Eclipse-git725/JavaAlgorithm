package algorithm;

/**
 * 文件名称: Algorithm3.java
 * 作者: gxy
 * 创建日期: 2025/4/21
 * 描述: 手撕反转链表练习
 * K个一组反转链表，如果剩下不足k个，剩下节点保持原有顺序
 */

public class Algorithm3 {
    public static ListNode ReverseList1 (ListNode head) {
        // 递归写法
        if(head == null || head.next == null) return head;
        ListNode node = ReverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static ListNode ReverseList2(ListNode head) {
        // 迭代写法
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        // k个一组反转链表
        int n = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while(cur != null) {
            n ++;
            cur = cur.next;
        }

        cur = head;
        ListNode pre = null, nxt = null;
        ListNode p0 = dummy;
        for(; n >= k; n -= k) {
            for (int i = 0; i < k; i++) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            nxt =  p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val);
            System.out.print("->");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3 ,4 , 5};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 1; i < 5; i ++ ) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }
        cur.next = null;
//        head = ReverseList1(head);
//        printList(head);
//        System.out.println();
//        head = ReverseList2(head);
//        printList(head);
//        System.out.println();
        head = reverseKGroup(head, 3);
        printList(head);
    }
}
