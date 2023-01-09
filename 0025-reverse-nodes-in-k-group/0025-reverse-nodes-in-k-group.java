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
    private int getLength(ListNode head){
        int l = 0;
        while(head != null){
            l++;
            head = head.next;
        }
        return l;
    }
    private ListNode reverseList(ListNode head, int k){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(k > 0){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            k--;
        }
        head.next = next;
        return prev;
    }
    private ListNode reverse(ListNode node, int k, int n){
        if(node == null || n < k){
            return node;
        }
        ListNode head = node;
        ListNode last = node;
        int i = 1;
        while(i < k){
            last = last.next;
            i++;
        }
        last.next = reverse(last.next, k, n - k);
        node = reverseList(head, k);
        return node;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = getLength(head);
        head = reverse(head, k, n);
        return head;
    }
}