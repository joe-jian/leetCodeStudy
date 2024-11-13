package everyday;

import java.util.HashSet;
import java.util.Set;

/**
* 相交链表
* leetcode 160
* */

public class getIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /**
    * 第一种解法 穷举法
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            throw new IllegalArgumentException("参数错误");
        }
        while (headA!=null){
            ListNode temp = headB;
            while (temp!=null){
                if (temp==headA){
                    return headA;
                }
                temp = temp.next;
            }
            headA = headA.next;
        }
        return null;
    }
/**
* 使用Set实现查询的功能
* */
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            throw new IllegalArgumentException("参数错误");
        }
        Set<Integer> set = new HashSet<>();
        while (headA!=null){
          set.add(headA.hashCode());
          headA = headA.next;
        }
        while (headB!=null){
            if (set.contains(headB.hashCode())){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    /**
    * 截取长度相同的部分，然后两者同时移动，直到找到相同节点
    *
    * */
    public ListNode getIntersectionNodeV3(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            throw new IllegalArgumentException("参数错误");
        }
        int ALength = getNodeLength(headA);
        int BLength = getNodeLength(headB);
        while (ALength>BLength){
            headA = headA.next;
            ALength--;
        }
        while (BLength>ALength){
            headB = headB.next;
            BLength--;
        }
        while (headA!=null && headB!=null){
            if (headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getNodeLength(ListNode headA) {
        int length = 0;
        while (headA!=null){
            length++;
            headA = headA.next;
        }
        return length;
    }
}
