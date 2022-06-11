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
        ListNode dummy = new ListNode(0);
        dummy.next = head; // reference to the head
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        for(int i = 1; i <= n+1; i++) {
            fast = fast.next; 
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
/*
1 -> 2 -> 3 -> 4 -> 5 | n = 2
using for loop -> i = 1 fast = 2, i = 2 fast = 3, i = 3 fast = 4, 

at the end of the for loop, fast = 4, slow is at the head, 
move fast and slow till fast != null
when fast = null, slow = 3

then remove the link -> slow.next = slow.next.next
*/
