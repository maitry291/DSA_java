package DSA_1DArray;

import java.util.Arrays;
//As selection sort needs two for loops to perform algorithm its best,worst,avg all time complexity
//are in order of n^2.
//space complexity=O(1).

public class SelectionSort {
    public static void main(String[] args) {
        int[] a={88,11,44,99,33};
        int counter=0,i;

        //we ll select counter=0 index as min element in array
        //now we ll travel in whole array to check whether min is actually minimum or not
        //after finding min element we ll swap it with counter index
        //after completing each counter loop we ll get the smallest element at the counter value position.
        for(counter=0;counter<a.length-1;counter++){
            int min=counter;
            for(i=counter+1;i<=a.length-1;i++){
                if(a[min]>a[i]){
                   min=i;
                }
            }
            int temp=a[counter];
            a[counter]=a[min];
            a[min]=temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
