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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        Stack<Integer> st = new Stack<>();
        int n = 0;
        while(fast != null && fast.next != null){
            st.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
            n += 2;
            if(fast != null && fast.next == null){
                n += 1;
            }
        }
        if(st.size() == 0){
            // if the list is not empty but the stack was empty then
            // list is [x, y]
            return (head.val == head.next.val);
        }
        
        if(n % 2 == 1){
            slow = slow.next;
        }
        while(slow != null){
            if(st.size() == 0 || st.pop() != slow.val){
                return false;
            }{
                slow = slow.next;
            }
        }

        return true;
    }
}