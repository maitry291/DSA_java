package DSA_BackTracking;
//we are given some numbers in array and amount from that we have to make permutations to reach tht amount from
//given numbers.
//remember undo part is implicitly done in method(coz of stack memory).

public class coinPermutation {
    public static void main(String[] args) {
        int[] a={2,3,5,6};
        getCoinPermutation(a,10,"");
    }
    public static void getCoinPermutation(int[] a,int amount,String ans){
        if(amount==0) {
            System.out.println(ans);
            return;
        }
        for (int j : a) {
            if (amount >= j) {
                getCoinPermutation(a, amount - j, ans + j);
            }
        }
    }
}
