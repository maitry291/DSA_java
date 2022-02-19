package DSA_DynamicProgramming;

//matrix chain multiplication
public class MCM {
    public static void main(String[] args) {
        int[] a={4,2,3,5,1};
        System.out.println(getMultiplicationOp(a,0,a.length-1));
    }

    public static int getMultiplicationOp(int[] a,int si,int li){
        if(si+1==li)
            return  0;

        int operations=Integer.MAX_VALUE;

        for(int k=si+1;k<=li-1;k++){
            int x=getMultiplicationOp(a,si,k);    //a[si] * a[k]
            int y=getMultiplicationOp(a,k,li);    //a[k] * a[li]

            int selfWork=a[si]*a[k]*a[li];

            int total=x+y+selfWork;

            if(total<operations)
                operations=total;
        }
        return operations;
    }

}
