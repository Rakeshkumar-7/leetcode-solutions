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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int N = 0;
        ListNode cur = head;
        while(cur != null){
            N++;
            cur = cur.next;
        }
        int prev = N-n-1;
        if(prev < 0){
            return head.next;
        }
        cur = head;
        for(int i=0; i<prev; i++){
            cur = cur.next;
        } 

        cur.next = cur.next != null ? cur.next.next : null;
        return head;
    }
}