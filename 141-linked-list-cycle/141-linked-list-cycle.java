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
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
/*
The base condition is if the head is null, if yes, then there's no cycle, otherwise, initialize slow as head and fast as head.next, 
using a loop, check whether fast != slow, in the loop, check if fast or the next of fast pointer is null, if yes then return false,
otherwise move slow pointer by one and fast pointer by 2, the point where they both points to the same value, we come out of the loop
and returns true.
*/