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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode less = list1;
        ListNode more = list2;
        if(list2.val < list1.val){
            less = list2;
            more = list1;
        }
        ListNode head = less;
        while(less != null && more != null){
            while(less.next != null && less.next.val <= more.val){
                less = less.next;
            }
            ListNode temp = less.next;
            less.next = more;
            more = temp;
        }
        
        if(more != null){
            less.next = more;
        }
        return head;
    }
}