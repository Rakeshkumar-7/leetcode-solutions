/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode swap(ListNode node, ListNode next){
        if(next == null){
            return node;
        }
        node.next = swap(next.next, (next.next != null)?next.next.next:null);
        next.next = node;
        return next;
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        return swap(head, head.next);
    }
}