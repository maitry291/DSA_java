package DSA_1DArray;

import java.util.Scanner;
//this algorithm is applicable only on a sorted array.
//time complexity:O(log n).(log of base 2)

public class BinarySearch {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9,10};
        int low=0,high=a.length-1,mid=0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter element to be searched:");
        int e=sc.nextInt();
        while(low<=high){
            mid=(low+high)/2;
           if(e==a[mid]){
              break;
           }else if(a[mid]<e){
               low=mid+1;
           }
           else if(a[mid]>e){
              high=mid-1;
           }
        }
        System.out.println("Element found at index:"+mid);
    }
}
