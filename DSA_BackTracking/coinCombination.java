package DSA_BackTracking;
//In this combination changes happens in stack memory location,
// so we don't need to do undo part explicitly(like Queens Problem).
//its being done implicitly.

public class coinCombination {
    public static void main(String[] args) {
        int[] a={2,3,5,6};
        getCoinCombination(a,10,"",0);
    }
    public static void getCoinCombination(int[] a,int amount,String ans,int lastElementUsed){
      if(amount==0) {
          System.out.println(ans);
          return;
      }
      for(int i=lastElementUsed;i<a.length;i++){
          if(amount>=a[i]) {
              getCoinCombination(a, amount - a[i], ans + a[i], i);
          }
      }
    }
}
