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
    private void swap(ListNode node1, ListNode node2){
        if(node1 == node2) return;
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
        return;
    }
    private int getLength(ListNode head){
        int i = 0;
        while(head != null){
            i++;
            head = head.next;
        }
        return i;
    }
    private ListNode getKthNode(ListNode head, int k){
        int i = 1;
        while(i < k){
            i++;
            head = head.next;
        }
        return head;
    }
    public ListNode swapNodes(ListNode head, int k) {
        int n = getLength(head);
        ListNode fromStart = getKthNode(head, k);
        ListNode fromEnd = getKthNode(head, n-k+1);
        swap(fromStart, fromEnd);
        return head;
    }
}