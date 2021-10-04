package DSA_Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class AllIndices {
    public static void main(String[] args) {
        int[] arr={3,8,1,8,8,7,7};
        System.out.println(allIndices(arr,0,0));
    }
    public static ArrayList<Integer> allIndices(int[] a, int si, int element){
        ArrayList<Integer> m=new ArrayList<>();
        while(si<a.length){
            if(a[si]==element) {
                m.add(si);
                si++;
                allIndices(a, si, element);
            }
            else {
                if(si==a.length-1)
                    return m;
                si++;
                allIndices(a,si,element);
            }
        }
        return m;
    }
}
