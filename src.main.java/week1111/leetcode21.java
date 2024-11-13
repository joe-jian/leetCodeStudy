package week1111;

/*
* 合并两个有序链表
* */
public class leetcode21 {

    //  Definition for singly-linked list.
      public static class ListNode {
         int val;
          ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
    public static void main(String[] args) {

          leetcode21 leetcode21 = new leetcode21();

          ListNode list1 = new ListNode(1);
          list1.next = new ListNode(2);
          list1.next.next = new ListNode(4);
          ListNode list2 = new ListNode(1);
          list2.next = new ListNode(3);
          list2.next.next = new ListNode(4);
          ListNode result = leetcode21.mergeTwoLists(list1, list2);
          while (result != null){
              System.out.print(result.val);
              result = result.next;
          }
    }
}
