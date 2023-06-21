/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;

        do{
            slow = slow.next;
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
        }while(slow != fast);

        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}