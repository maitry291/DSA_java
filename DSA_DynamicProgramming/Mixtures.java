package DSA_DynamicProgramming;

import java.util.Arrays;

public class Mixtures {
    public static void main(String[] args) {
        int[] a={40,60,20};
        System.out.println(getSmokeRecursive(a,0,a.length-1));
        int[][] s=new int[a.length][a.length];
        for(int[] r:s){
            Arrays.fill(r,-1);
        }
        System.out.println(getSmokeTD(a,0,a.length-1,s));
//        for(int[] r:s){
//            System.out.println(Arrays.toString(r));
//        }
        System.out.println(getSmokeBU(a));
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
            //System.out.println(i+"-"+ans);
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

    public static int getSmokeBU(int[] a){
        int n=a.length;
        int[][] storage=new int[n][n];

        for(int slide=0;slide<n;slide++){
            for(int si=0;si<n-slide;si++){
                int li=slide+si;

                int ans=Integer.MAX_VALUE;
                for(int i=si;i<li;i++){

                    int smoke1=storage[si][i];
                    int smoke2=storage[i+1][li];

                    int sw=getColour(a,si,i)*getColour(a,i+1,li);

                    int total=smoke1+smoke2+sw;

                    if(total<ans){
                        ans=total;
                    }
                    storage[si][li]=ans;
                }
            }
        }

        return storage[0][n-1];
    }

    public static int getColour(int[] a,int si,int li){
        int sum=0;
        for(int i=si;i<=li;i++){  //i<= this = is important when si=li
            sum+=a[i];
        }
        return sum%100;
    }
}
