package com.dianping.AddTwoNumbers;

public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode result = getResult(l1, l2);
        ListNode tmp = result;
        while(tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
    
    private static ListNode getResult(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l3 = new ListNode((l1.val + l2.val) % 10);
        int inr = (l1.val + l2.val) / 10;
        ListNode tmp = new ListNode(0);
        l3.next = tmp;
        int count = 1;
        while (l1.next != null || l2.next != null) {
            count = count + 1;
            if (l1.next == null) {
                tmp.val = (l2.next.val + inr) % 10;
                inr = (l2.next.val + inr) /10;
                l2 = l2.next;
                tmp.next = new ListNode(0);
                tmp = tmp.next;
                continue;
            }
            if (l2.next == null) {
                tmp.val = (l1.next.val + inr) % 10;
                inr = (l1.next.val + inr) / 10;
                l1 = l1.next;
                tmp.next = new ListNode(0);
                tmp = tmp.next;
                continue;
            }
            tmp.val = (l1.next.val + l2.next.val + inr) % 10;
            inr = (l1.next.val + l2.next.val + inr) / 10;
            l1 = l1.next;
            l2 = l2.next;
            tmp.next = new ListNode(0);
            tmp = tmp.next;
        }
        if ( inr != 0 ) {
            tmp.val = inr;
            return l3;
        }
        tmp = l3;
        for (int i = 0; i < count - 1; i++) {
            tmp = tmp.next;
        }
        tmp.next = null;
        return l3;
    }
}
