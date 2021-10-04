package DSA_1DArray;
//best case time complexity[big-omega]:O(n)-->when array is already sorted.
//worst case happens when array is sorted in decreasing order and we have to sort it in increasing order.
//worst case complexity:o(n^2).
//space complexity:O(1)--.coz  only a single additional memory space is required i.e. for temp variable.

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a={88,11,44,99,33};
        int counter,i=0;
        for(counter=0;counter<a.length-1;counter++){ //when counter=0 finishes one element will be
            // at the correct position(that one element is the largest element of array)
            for(i=0;i<a.length-1;i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
