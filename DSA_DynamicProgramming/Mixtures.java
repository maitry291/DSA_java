package DSA_DynamicProgramming;

public class Mixtures {
    public static void main(String[] args) {
        int[] a={40,60,20};
        System.out.println(getSmokeRecursive(a,0,a.length-1));
    }

    public static int getSmokeRecursive(int[] a,int si,int li){
        if(si==li){
            return 0;
        }

        int ans=Integer.MAX_VALUE;
        for(int i=si;i<li;i++){

            //a[i+1]=(a[i]+a[i+1])%100;
            int smoke1=getSmokeRecursive(a,si,i);
            int smoke2=getSmokeRecursive(a,i+1,li);

            int sw=getColour(a,si,i)*getColour(a,i+1,li);

            int total=smoke1+smoke2+sw;

            if(total<ans){
                ans=total;
            }

        }
        return ans;
    }
    public static int getSmokeTD(int[] a,int si,int li,int[][] storage){
        if(si==li){
            return 0;
        }
        if(storage[si][li]!=-1)
            return storage[si][li];

        int ans=Integer.MAX_VALUE;
        for(int i=si;i<li;i++){

            //a[i+1]=(a[i]+a[i+1])%100;
            int smoke1=getSmokeTD(a,si,i,storage);
            int smoke2=getSmokeTD(a,i+1,li,storage);

            int sw=getColour(a,si,i)*getColour(a,i+1,li);

            int total=smoke1+smoke2+sw;

            if(total<ans){
                ans=total;
            }

        }
        storage[si][li]=ans;
        return ans;
    }

    public static int getColour(int[] a,int si,int li){
        int sum=0;
        for(int i=si;i<=li;i++){
            sum+=a[i];
        }
        return sum%100;
    }
}
