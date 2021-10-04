package DSA_Queue;

public class kWindows {
    public static void main(String[] args) {
       int[] a={1,2,3,0,1,4,5,6,7,1};
       largestElement(a,0,3,3);
    }
    public static void largestElement(int[] a,int si,int li,int k){
       // li=si+k;
        if(li>=a.length)
            return;
        int max=a[si];
        for(int i=si;i<li;i++){
            if(max<a[i]){
               max=a[i];
            }
        }
        System.out.println(max);
        largestElement(a,si+1,li+1,k);
    }
}
