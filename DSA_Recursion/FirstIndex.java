package DSA_Recursion;

public class FirstIndex {
    public static void main(String[] args) {
       int[] arr={1,2,3,3,3,4,5};
        System.out.println(firstIndex(arr,0,3));
    }
    public static int firstIndex(int[] a,int si,int element){
       while(si<a.length){
           if(a[si]==element)
               return si;
           else {
               if(si==a.length-1)
                   break;
               si++;
               firstIndex(a,si,element);
           }
       }
       return -1;
    }
}
