package DSA_7_Challanges;
//The naive method is to run two loops. The outer loop picks the beginning element,
// the inner loop finds the maximum possible sum with first element picked by outer loop and
// compares this maximum with the overall maximum.
// Finally, return the overall maximum. The time complexity of the Naive method is O(n^2).

//there is another method available with time complexity o(n).

//Using Divide and Conquer approach,
//we can find the maximum sub-array sum in O(n*Log n) time. Following is the Divide and Conquer algorithm.

public class maxSumOfSubArray {
    // A Divide and Conquer based Java
// program for maximum sub-array sum
// problem
        // Find the maximum possible sum in arr[]
        // such that arr[m] is part of it
    /* Driver program to test maxSubArraySum */
    public static void main(String[] args)
    {
        int[] arr = { 2, 3, 4, 5, 7 };
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, 0, n - 1);

        System.out.println("Maximum contiguous sum is " + max_sum);
    }

    static int maxCrossingSum(int[] arr, int l, int m, int h) {
            // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

            // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        // Return sum of elements on left
        // and right of mid
        // returning only left_sum + right_sum will fail for
        // [-2, 1]
        return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum));
        }

        // Returns sum of maximum sum sub-array
        // in aa[l..h]
        static int maxSubArraySum(int[] arr, int l, int h)
        {
            // Base Case: Only one element
            if (l == h)
                return arr[l];

            // Find middle point
            int m = (l + h) / 2;

		/* Return maximum of following three
		possible cases:
		a) Maximum sub-array sum in left half
		b) Maximum sub-array sum in right half
		c) Maximum sub-array sum such that the
		sub-array crosses the midpoint */
        return Math.max(Math.max(maxSubArraySum(arr, l, m), maxSubArraySum(arr, m + 1, h)),
         maxCrossingSum(arr, l, m, h));
        }
}
