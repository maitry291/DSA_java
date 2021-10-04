package DSA_Recursion;

public class isSortedArray {
    public static void main(String[] args) {
        int[] arr={1,3,4,5,8};
        System.out.println("Is array sorted?->"+isSorted(arr,0));
    }
    public static boolean isSorted(int[] a,int si){
       // int counter=1;
        while(si<a.length){
            if(si==a.length-1)
                return true;
           else if(a[si]<a[si+1]) {
                si++;
                isSorted(a,si );
               // counter++;
            }
            else
                break;
        }
        return false;
    }
}
