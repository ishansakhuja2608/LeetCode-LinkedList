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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count += 1; // count the number of nodes in the list
            temp = temp.next;
        }
        int arr[] = new int[count];
        temp = head;
        int i = 0;
        while(temp != null) {
            arr[i++] = temp.val; // store the values of the nodes in the array
            temp = temp.next;
        }
        Arrays.sort(arr); // sort using the array function
        temp = head;
        i = 0;
        while(temp != null) {
            temp.val = arr[i++]; // assign the sorted values to the nodes of the list
            temp = temp.next;
        }
        return head;
    }
}