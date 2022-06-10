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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        int sum = 0;
        int carry = 0;
        
        Stack<Integer> s1 = new Stack<>(); // stack for reversing the list
        Stack<Integer> s2 = new Stack<>();
        
        while(l1 != null) {
            s1.push(l1.val); // pushing the values to the stack
            l1 = l1.next; 
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int l1Val = 0;
            int l2Val = 0;
            
            
            if(!s1.isEmpty()) {
                l1Val = s1.pop();
            }
            if(!s2.isEmpty()) {
                l2Val = s2.pop();
            }
            
            sum = l1Val + l2Val + carry; // creating a particular sum for particular nodes
            carry = sum/10; // updating the carry
            ListNode temp = new ListNode(sum % 10); // last digit as the node
            
            if(res == null) {
                res = temp;
            }
            else {
                temp.next = res;
                res = temp;
            }
        }
        if(carry != 0) {
            ListNode temp = new ListNode(carry);
            temp.next = res;
            res = temp;
        }
        return res;
    }
}