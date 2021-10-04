package DSA_Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={50,40,30,20,10};
        bubbleSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] a,int si,int li){
        if(li==0)
            return;
        if(si==li) {
            bubbleSort(a, 0, li - 1);
            return;
        }
        if(a[si]>a[si+1]){
            int temp = a[si];
            a[si] = a[si + 1];
            a[si + 1] = temp;
        }
        bubbleSort(a,si+1,li);
    }
}
