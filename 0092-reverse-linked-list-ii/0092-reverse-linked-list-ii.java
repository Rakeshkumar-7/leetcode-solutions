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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        ListNode before = null;
        if(left > 1){
            before = head;
            for(int i=1; i+1<left; i++){
                before = before.next;
            }
        }
        int n = right - left + 1;
        ListNode prev = before;
        ListNode cur = (before == null)?head:before.next;
        ListNode start = cur;
        ListNode next = null;
        while(n > 0){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            n--;
        }
        if(before != null){
            before.next = prev;
        }
        start.next = cur;
        return (left > 1)?head:prev;
    }
}