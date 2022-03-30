package DSA_7_Challanges;

import java.util.Arrays;
//this is the worst case method as its time complexity is O(n^2)[coz of 2 for loops].
//last method has linear complexity.

public class MaxSum1 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
      int[] arr={-2,-5,6,2,-3,1,5,-6};
        System.out.println(maxSum(arr));
        System.out.println(maxSubArraySum(arr));
    }
    //O(n^2)
    public static int maxSum(int[] a){
        int[] max_sum=new int[a.length];
        for(int i=0;i<a.length;i++){
            int sum=0;
            max_sum[i]=a[i];
            for(int j=i;j<a.length;j++){
                sum+=a[j];
                if(sum>max_sum[i])
                    max_sum[i]=sum;
            }
        }
        Arrays.sort(max_sum);
        return max_sum[a.length-1];
    }
    //O(n) kadane's algo
    static int maxSubArraySum(int[] a)
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int j : a) {
            max_ending_here = max_ending_here + j;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

}
