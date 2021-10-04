package DSA_Recursion;

public class LastIndex {
    public static void main(String[] args) {
        int[] arr={3,8,1,8,8,7};
        System.out.println(lastIndex(arr,0,8));
    }
    public static int lastIndex(int[] a,int si,int element){
        int m=-1;
        while(si<a.length){
            if(a[si]==element) {
                m=si;
                si++;
                lastIndex(a, si, element);
            }
            else {
                if(si==a.length-1)
                    return m;
                si++;
                lastIndex(a,si,element);
            }
        }
        return m;
    }
}
