/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while(l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}
/*
if l1 and l2 have different lengths ,then the end of l1 will start from the head of l2 and vice versa, due to this, after a specific number of iterations,
both the pointers will end up at equal length, and we can check if there's any intersection point
*/
