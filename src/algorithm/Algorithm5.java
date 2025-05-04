package algorithm;

/**
 * 文件名称: Algorithm5.java
 * 作者: gxy
 * 创建日期: 2025/4/23
 * 描述: 合并多个链表
 */
public class Algorithm5 {
    // 合并两个有序链表
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
               cur.next = list1;
               list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 != null) cur.next = list1;
        if(list2 != null) cur.next = list2;
        return dummy.next;
    }

    // 合并lists[i,j]的有序链表
    private ListNode mergeKLists(ListNode[] lists, int i, int j) {
        if(j == i) return lists[0];
        if(j < i) return null;
        int mid = (i + j) / 2;
        ListNode left = mergeKLists(lists, i, mid);
        ListNode right = mergeKLists(lists, mid + 1, j);
        ListNode node = mergeTwoLists(left, right);
        return node;
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
        Algorithm5 algorithm5 = new Algorithm5();
        int[] arr = {1, 2, 3 ,4 , 5};
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode cur = head1;
        for(int i = 1; i < 5; i ++ ) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }
        cur.next = null;
        cur = head2;
        for(int i = 1; i < 5; i ++ ) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }
        cur.next = null;
        head1 = algorithm5.mergeTwoLists(head1, head2);
        printList(head1);
    }
}
