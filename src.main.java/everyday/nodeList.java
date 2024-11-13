package everyday;

public class nodeList {

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
  public  static   class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            long num1=0;
            long num2=0;
            num1 = getNum1(l1, num1, num2);

            long num3=0;
            num2=0;
            num3 = getNum1(l2, num3, num2);
            long num4 = num1 + num3;
            return createListNode(num4);
        }

      private long getNum1(ListNode l1, long num1, long num2) {
          while (l1 != null){
              if (num2==0){
                  num1+=l1.val;
              }else {
                  num1+= l1.val*Math.pow(10,num2);
              }
              num2++;
              l1 = l1.next;
          }
          return num1;
      }

      private ListNode createListNode(long sum) {
          if (sum == 0) {
              return new ListNode(0);
          }
          ListNode dummy = new ListNode(0);
          ListNode current = dummy;
          while (sum > 0) {
              current.next = new ListNode((int)(sum % 10));
              current = current.next;
              sum /= 10;
          }
          return dummy.next;
      }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result != null){
            System.out.print(result.val);
            result = result.next;
        }
    }
}
