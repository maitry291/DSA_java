package DSA_7_Challanges;

public class ques16 {
    public static void main(String[] args) {
       int[] a={1,2,3,-5,4};
       // System.out.println(subsetSum(a,0));
        subsetSum(a,0);
    }
    public static void subsetSum(int[] a,int sum){
        if(a.length==0) {
           // System.out.println(sum);
            return;
        }
       int m=a[0];
       int[] na=new int[a.length-1];
        for(int i=0;i<na.length;i++){
            na[i]=a[i+1];
        }
        subsetSum(na,sum);
        subsetSum(na,sum+m);
       // System.out.println(sum+m);
        if((sum+m)==0)
            System.out.println("yes");

    }
}
