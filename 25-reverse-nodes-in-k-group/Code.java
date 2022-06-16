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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0, head); // dummy.next = head;
        ListNode curr = dummy;
        ListNode next = dummy;
        ListNode prev = dummy;
        int count = 0;
        while(curr.next != null) {
            curr = curr.next;
            count++; // count the number of nodes in the list
        }
        while(count >= k) {
            curr = prev.next; // curr is standing at the first node
            next = curr.next; // next is at the second node of that particular group of size k
            for(int i=1; i<k; i++) { // have to reverse k-1 links
                curr.next = next.next; // 1 -> 3
                next.next = prev.next; // 2 -> 1
                prev.next = next; // keeping a track, cause next is gonna be the next current node
                next = curr.next; 
            }
            prev = curr;
            count -= k;
        }
        return dummy.next;
    }
}
