package DSA_7_Challanges;

import java.util.ArrayList;
import java.util.Collections;

import static DSA_Recursion_Arraylist.Permutation.getPermutation;

public class ques22 {
    public static void main(String[] args) {
         dictionaryOrder("cabd","");
    }
    //without recursion
    public static void dictionaryOrder(String str,String ans) {
        ArrayList<String> permutations=getPermutation(str);
          permutations.remove(str);
          permutations.remove("");
          for(String x:permutations){
              if(x.compareTo(str)>0)
                  System.out.println(x);

          }
    }
    //without recursion
    public static void dictionaryOrder(String str) {
        ArrayList<String> permutations=getPermutation(str);
        Collections.sort(permutations);
        //System.out.println(permutations);
        for(int i= permutations.indexOf(str)+1;i<permutations.size();i++){
            System.out.println(permutations.get(i));
        }
    }
}
