package DSA_BackTracking;

public class coinRespectCoinCombination {
    public static void main(String[] args) {
        coinCombination_wrtCoin(new int[]{1,2,3},4,0,"");
    }
    public static void coinCombination_wrtCoin(int[] denom,int amount,int vi,String path ) {
        if(amount==0){
            System.out.println(path);
            return;
        }
        if(amount<0)
            return;
        if(vi== denom.length)
            return;

        coinCombination_wrtCoin(denom,amount-denom[vi],vi,path+denom[vi]);
        coinCombination_wrtCoin(denom,amount,vi+1,path);

    }
}