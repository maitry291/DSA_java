package DSA_TimeSpace_Complexity;
//time complexity:-n*log n(in all three cases this remains same).
//merge sort always divides the array in two halves(log n) and takes linear time(n) to merge two halves.

import java.util.Arrays;
//merge2sortedArrays method takes two sorted array as parameters and then merge them and sort them in a "new array".
//it doesn't make any changes in original arrays.
//mergeSort algorithm uses above method and sorts array

public class MergeSortedArrays {
    public static void main(String[] args) {
          int[] a1={2,10,20,30,40}; //sorted array
          int[] a2={5,15,25,35,40}; //sorted array
         // int[] a={40,3,69,20,15};
        //System.out.println(Arrays.toString(merge2SortedArrays(a1,a2)));
        int n=10000000;
        int[] a=new int[n];
        for(int i=n-1;i>=0;i--){
            a[n-i-1]=i;
        }
        //System.out.println(Arrays.toString(a));

        Long start=System.currentTimeMillis();

        mergeSort(a,0,a.length-1);

        //Instant end = Instant.now();
        Long stop=System.currentTimeMillis();
        System.out.println("time ="+(stop-start)+" milliseconds");

    }
    public static int[] merge2SortedArrays(int[] a1,int[] a2) {
        int i = 0, j = 0, k = 0;
        int[] merge = new int[a1.length + a2.length];
        while (i < a1.length && j < a2.length) {
            if(a1[i] <= a2[j]) {
                merge[k] = a1[i];
                i++;
                k++;
            }
            else{
                merge[k] = a2[j];
                j++;
                k++;
            }
        }
        if(i==a1.length){
            while(j<a2.length){
                merge[k] = a2[j];
                j++;
                k++;
            }
        }
        if(j==a2.length){
            while(i<a1.length){
                merge[k] = a1[i];
                i++;
                k++;
            }
        }
        return merge;
    }
    public static int[] mergeSort(int[] a,int low,int high){

        if(low==high){
            int[] base=new int[1];
            base[0]=a[low];
            return base;
        }
        int mid=(low+high)/2;
        //two parts of array:fh=first-half,sh=second-half.
        int[] fh=mergeSort(a,low,mid);
        int[] sh=mergeSort(a,mid+1,high);

        return merge2SortedArrays(fh,sh);
    }
}
