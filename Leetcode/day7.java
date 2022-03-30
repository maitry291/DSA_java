package Leetcode;

import java.util.Arrays;

public class day7 {
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

    }

    public static void main(String[] args) {
        int[] a={-1,0,0,0,3,0,0,0,0,0,0};
        merge(a,5,new int[]{-1,-1,0,0,1,2},6);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0,ptr,dlm=m;
        if(n==0)
            return;
        for(int i=0;i<m+n &&j<n;i++){
            System.out.println(Arrays.toString(nums1));
            if(nums1[i]==0 && i>=dlm) {
                nums1[i] = nums2[j];
                j++;
                continue;
            }
            if(nums1[i]<nums2[j]) {
                continue;
            }
            if(nums1[i]>nums2[j]){
                ptr=dlm-1;
                for(int k=dlm;k>i && ptr>=0;k--){
                    int temp=nums1[ptr];
                    nums1[ptr]=nums1[k];
                    nums1[k]=temp;
                    ptr--;
                }
                nums1[i]=nums2[j];
                j++;
                dlm++;
                System.out.println(Arrays.toString(nums1));
                continue;
            }
            if(nums1[i]==nums2[j]){
                ptr=dlm-1;
                for(int k=dlm;k>i+1;k--){
                    int temp=nums1[ptr];
                    nums1[ptr]=nums1[k];
                    nums1[k]=temp;
                    ptr--;
                }
                nums1[i+1]=nums2[j];
                j++;
                dlm++;
            }

        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head, list = head;

        while (temp != null) {
            if(temp.next==null){
               list.next=null;
               break;
            }
            if (temp.val != temp.next.val) {
                if (list.next != temp.next)
                    list.next = temp.next;
                list = list.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
