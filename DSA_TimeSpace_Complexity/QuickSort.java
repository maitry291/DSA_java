package DSA_TimeSpace_Complexity;
//After selecting an element as pivot, which is the last index of the array in our case,
// we divide the array for the first time.
//In quick sort, we call this partitioning. It is not simple breaking down of array into 2 sub-arrays,
// but in case of partitioning, the array elements are so positioned that all the elements smaller
// than the pivot will be on the left side of the pivot and all the elements greater than
// the pivot will be on the right side of it.
//And the pivot element will be at its final sorted position.
//The elements to the left and right, may not be sorted.
//Then we pick sub-arrays, elements on the left of pivot and elements on the right of pivot,
// and we perform partitioning on them by choosing a pivot in the sub-arrays.

//for time complexity refer abdul bari lec yt.

import java.util.Arrays;
//In this sorting algorithm we select an element of array(any element here we selected mid) as a pivot.
//then we compare each element with pivot then do some operations to get sorted array.

public class QuickSort {
    public static void main(String[] args) {
        int[] a={40,3,69,20,15};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int[] a,int low,int high){
        //base case
        if(low>=high){
           return;
        }
        //partitioning-->time taken by this process is n as it compares element with pivot then swaps.
        //partitioning method sorts pivot element.
        int mid=(low+high)/2;
        int l=0,r=a.length-1;
        int pivot=a[mid];  //pivot can be any element of array.
        while(l<=r){
            while(a[l]<pivot)  //this loop will execute until the condition is true
                l++;
            while(a[r]>pivot)
                r--;
           if(l<=r) {    //ina any other situation we will swap both elements.
               int temp = a[l];
               a[l] = a[r];
               a[r] = temp;
               l++;
               r--;
           }
        }
        //time taken to divide array is log n(base 2)-->best case(when array is not sorted,pivot can be any)
      //recursion for smaller problem
        quickSort(a,low,r);
        quickSort(a,l,high);

    }

}
//time complexity of worst case:--don't compare this with best case both are different things
//worst case happens(most time) when array is already sorted.
//array will be divided in size (n-1),n-2,n-3,....,2 like this so complexity is in order of n^2.
