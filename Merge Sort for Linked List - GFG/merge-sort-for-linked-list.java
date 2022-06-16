// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        if(head == null || head.next == null) 
            return head;
        
        Node temp = head;
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            temp = slow;                // temp will be the end of the first half list
            slow = slow.next;           // slow -> head of second half
            fast = fast.next.next;      // fast -> end of the second half
        }
        temp.next = null;               // divided the list into two halves
        
        // Recursive calls
        Node leftHalf = mergeSort(head);
        Node rightHalf = mergeSort(slow);
        
        return  merge(leftHalf, rightHalf);
    }
    
    private static Node merge(Node l1, Node l2) {
        Node sortedHead = new Node(0); 
        Node currentNode = sortedHead; // Reference to the head
        
        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                currentNode.next = l1;
                l1 = l1.next;
            }
            else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        // edge cases -> if any of the lists head null
        if(l1 != null) {
            currentNode.next = l1;
            l1 = l1.next;
        }
        
        if(l2 != null) {
            currentNode.next = l2;
            l2 = l2.next;
        }
        
        return sortedHead.next;            
    }
}