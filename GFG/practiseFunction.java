package GFG;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class practiseFunction {
    public static void main(String[] args) {
        int[] a = {2, 6, 3, 4, 7, 2, 10, 3, 2, 1};
        int[] a2 = {1, 4,3,2,6,7};
        System.out.println(minJumps(a2));

    }

    void merge(int a1[], int a2[], int n, int m) {
        // code here
        for(int i=0;i<Math.min(m,n);i++){
            System.out.print(Math.min(a1[i],a2[i])+" ");
        }
        if(a1.length>a2.length) {
            for (int i =a2.length;i<a1.length;i++){

            }
        }
    }

    public int findDuplicate(int[] nums) {
        //int freq=0;
        HashMap<Integer,Integer> frequency=new HashMap<>();
        for(int e:nums){
            if(frequency.containsKey(e))
                return e;
            frequency.put(e,1);
        }
        return -1;
    }

    static int minJumps(int[] arr) {
        // your code here
        int step = 0, max_step, i = arr[0],rs;

        if (arr.length == 1)
            return 0;

        while (i < arr.length) {
            step++;
            if(i==arr.length-1)
                return step;

            max_step = arr[i];
            rs=arr.length-i-1;

            if(max_step<arr.length) {
                i += Math.min(rs,max_step);
            }
            else
                return -1;

        }

        return step;
    }

    public static int getMinDiff(int[] arr, int n, int k) {
        // code here
        arr = mergeSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));

//        int mid = n / 2;
//        for (int i = 0; i < mid; i++) {
//            arr[i] += k;
//        }
//        for (int j = mid; j < n; j++) {
//            if (arr[j] - k >= 0&&(arr[j]-arr[0]-k)>=0)
//                arr[j] -= k;
//        }
        System.out.println(Arrays.toString(arr));
        return arr[n - 1] - arr[0];
    }

    public static int[] merge2SortedArrays(int[] a1, int[] a2) {
        int i = 0, j = 0, k = 0;
        int[] merge = new int[a1.length + a2.length];
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                merge[k] = a1[i];
                i++;
                k++;
            } else {
                merge[k] = a2[j];
                j++;
                k++;
            }
        }
        if (i == a1.length) {
            while (j < a2.length) {
                merge[k] = a2[j];
                j++;
                k++;
            }
        }
        if (j == a2.length) {
            while (i < a1.length) {
                merge[k] = a1[i];
                i++;
                k++;
            }
        }
        return merge;
    }

    public static int[] mergeSort(int[] a, int low, int high) {

        if (low == high) {
            int[] base = new int[1];
            base[0] = a[low];
            return base;
        }
        int mid = (low + high) / 2;
        //two parts of array:fh=first-half,sh=second-half.
        int[] fh = mergeSort(a, low, mid);
        int[] sh = mergeSort(a, mid + 1, high);

        return merge2SortedArrays(fh, sh);
    }

    //incomplete
    public static long maxSubarraySum(int arr[], int n) {
        int sum = 0;
        // Your code here
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (sum(arr, i, j) > sum)
                    sum = sum(arr, i, j);
            }
        }
        return sum;
    }

    static int sum(int a[], int si, int li) {
        int sum = 0;
        for (int i = si; i < li; i++) {
            sum += a[i];
        }
        return sum;
    }

   /* //Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node node)
    {
        // Your code here
        ArrayList<Integer> nodes=new ArrayList<>();
        nodes.add(node.data);
    }*/
}
