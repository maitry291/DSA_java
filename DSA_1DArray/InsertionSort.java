package DSA_1DArray;
//We start by making the second element of the given array, i.e. element at index 1, the key.
// The key element here is the new card that we need to add to our existing sorted set of cards(remember
// the example with cards above).
//We compare the key element with the element(s) before it, in this case, element at index 0:
//If the key element is less than the first element, we insert the key element before the first element.
//If the key element is greater than the first element, then we insert it after the first element.
//Then, we make the third element of the array as key and will compare it with elements to it's left
// and insert it at the right position.
//And we go on repeating this, until the array is sorted.

//Worst Case Time Complexity [ Big-O ]: O(n2)
//Best Case Time Complexity [Big-omega]: O(n)-->when array is already sorted.
//Average Time Complexity [Big-theta]: O(n2)
//Space Complexity: O(1)

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a={88,11,44,99,33};
        int counter,temp,val;
        for(counter=1;counter<=a.length-1;counter++){ //after completion of every counter loop the array will be
            //sorted till the counter value
            val=a[counter];
            int i=counter-1;
            while(i>=0&&a[i]>val) {
                if (a[i] > val) {
                    a[i+1] = a[i];
                }
                i--;
            }
            a[i+1]=val; //after checking elements in reverse loop we ll insert the element val at the position
            // where the element before it is not larger than itself.

        }
        System.out.println(Arrays.toString(a));
    }
}
