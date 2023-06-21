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
        ListNode head = new ListNode();
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.val <= list2.val){
            head.val = list1.val;
            list1 = list1.next;
        }else{
            head.val = list2.val;
            list2 = list2.next;
        }

        ListNode cur = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = new ListNode(list1.val);
                list1 = list1.next;        
            }else{
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 != null){
            cur.next = list1;
        }
        if(list2 != null){
            cur.next = list2;
        }
        return head;
    }
}