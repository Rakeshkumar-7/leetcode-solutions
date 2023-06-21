/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lastA = null;
        ListNode cur = headA;
        while(cur != null){
            lastA = cur;
            cur = cur.next;
        }

        lastA.next = headA;

        ListNode slow = headB;
        ListNode fast = headB;

        do{
            slow = slow.next;

            // fast would be null if there is no intersection, since it won't be in the loop
            if(fast == null || fast.next == null){
                lastA.next = null;   
                return null;
            }
            fast = fast.next.next;
        }while(slow != fast);
        
        fast = headB;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        lastA.next = null;
        return slow;
    }
}