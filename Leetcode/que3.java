package Leetcode;

import java.util.Arrays;

public class que3 {
    public static void main(String[] args) {
        int[] a={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(a));
        System.out.println(removeElement(a,2));
    }

    public static int searchInsert(int[] nums, int target) {
        int low=0,high= nums.length-1;
        int mid=0;

        while(low<=high){

            mid=(low+high)/2;

            //binary search
            if(nums[mid]==target)
                return mid;

            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return high+1;
    }

    public static int strStr(String haystack, String needle) {
        int n=needle.length();
        if(n==0)
            return 0;
        for(int i=0;i<=haystack.length()-n;i++){
            String ans=haystack.substring(i,i+n);
            if(ans.equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static int removeDuplicates(int[] nums) {
        int k=1;
        for(int i=0;i< nums.length-1;i++){
            for(int j=i+1;j< nums.length;j++){
                if(nums[i]!=nums[j]&&nums[i]<nums[j]){
                    nums[i+1]=nums[j];
                    break;
                }
            }
        }
        for(int i=0;i< nums.length-1;i++){
            if(nums[i]<nums[i+1])
                k++;
            else
                break;
        }

        return k;
    }

    public static int removeElement(int[] nums, int val) {
        int k=0;

        for(int i=0;i< nums.length;i++){
            for(int j=i;j< nums.length && nums[i]==val;j++){
                if(nums[j]!=val){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    break;
                }
            }
        }
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=val)
                k++;
            else
                break;
        }
        return k;
    }
}
