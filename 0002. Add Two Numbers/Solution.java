// Question: https://leetcode.com/problems/add-two-numbers
// Created on: 2023-03-28

class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        ListNode resHead = new ListNode(-1), resCur = resHead;
        int rem = 0;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) cur1 = new ListNode(0);
            if (cur2 == null) cur2 = new ListNode(0);
            ListNode newNode = new ListNode((cur1.val + cur2.val + rem) % 10);
            rem = (cur1.val + cur2.val + rem) / 10;
            resCur.next = newNode;
            resCur = resCur.next;
            cur1 = cur1.next; cur2 = cur2.next;
        }
        if (rem == 1) resCur.next = new ListNode(1);
        return resHead.next;
    }
    
}

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