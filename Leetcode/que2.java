package Leetcode;

public class que2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
//        public int size(){
//            int size=0;
//
//        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode temp1 = list1, temp2 = list2, temp3;
        if(list1==null&&list2==null)
            return ans;
        if(list1!=null&&list2==null)
            return list1;
        if(list2!=null&&list1==null)
            return list2;

        if (list1.val <= list2.val) {
            ans.val = list1.val;
            temp1 = list1.next;
        } else {
            ans.val = list2.val;
            temp2 = list2.next;
        }
        temp3 = ans;
        while (temp1 != null && temp2 != null) {
            ListNode nn;
            if (temp1.val <= temp2.val) {
                nn = new ListNode(temp1.val);
                temp3.next = nn;
                temp1 = temp1.next;
            } else {
                nn = new ListNode(temp2.val);
                temp3.next = nn;
                temp2 = temp2.next;
            }
            temp3 = nn;
        }
        if(temp1!=null){
            temp3.next=temp1;
        }
        if(temp2!=null){
            temp3.next=temp2;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode l2=new ListNode(1,new ListNode(3,new ListNode(4,null)));

        mergeTwoLists(l1,l2);
    }
}
