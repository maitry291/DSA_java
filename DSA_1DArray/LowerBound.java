package DSA_1DArray;

//we used binary search in finding both the bounds
import java.util.Scanner;

public class LowerBound {
    public static void main(String[] args) {
        int[] a= {1,1,1,2,2,2,2,2,3,3};
        int mid,low=0,high=a.length,i=0;
        int ind=0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter element to know lower bound:");
        int e=sc.nextInt();
        while(low<high){
            mid = (low + high) / 2;
            if (a[mid] == e) {
                ind= mid;
                high = mid;
                i++;
            }
            else if (a[mid] < e) {
               low=mid+1;
            }
            else if(a[mid]>e){
                high=mid;
            }
        }
        System.out.println(ind);
    }
}
