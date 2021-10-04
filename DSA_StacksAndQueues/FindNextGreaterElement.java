package DSA_StacksAndQueues;

import java.util.Stack;

public class FindNextGreaterElement {
    public static void main(String[] args) {
        //inbuilt class
        Stack<Integer> stack=new Stack<>();
        int[] a={2,1,3,8,7,5};
        //time complexity ->O(2n)=O(n)
        for(int i=0;i<a.length;i++){
            while(!stack.empty()&&a[i]>stack.peek()){
                int rv=stack.pop();
                System.out.println(rv+"->"+a[i]);
            }
            stack.push(a[i]);
        }
        while(!stack.isEmpty()){
            int rv=stack.pop();
            System.out.println(rv+"-"+-1);
        }

        getNextGreaterElement(a,0);
    }
    public static void getNextGreaterElement(int[] a,int si){
        //this method has worst case time complexity of n^2.
        if(si==a.length)
            return;
        for(int i=si+1;i<a.length;i++){
            if(a[i]>a[si]){
                System.out.println(a[si]+"->"+a[i]);
                break;
            }
        }
        getNextGreaterElement(a,si+1);
    }

}
