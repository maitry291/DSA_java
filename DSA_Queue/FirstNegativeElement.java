package DSA_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeElement {
    public static void main(String[] args) {
        int[] a={12,-1,-7,8,-15,30,16,28};
        firstNegative(a,3,0);
        System.out.println();
        firstNegativeQ(a,3);
    }

    //O(n) time,O(K) space
    //better approach with queue
    public static void firstNegativeQ(int[] a ,int k){
        Queue<Integer> queue=new LinkedList<>();
        int i;
        for(i=0;i<k;i++){
            if(a[i]<0)
                queue.add(i);
        }
        for(;i<a.length;i++){
            //this is for the above loop window
            if(!queue.isEmpty())
                System.out.print(a[queue.peek()]+" ");
            else
                System.out.print(0+" ");


            while(!queue.isEmpty()&&queue.peek()<=i-k){
                queue.remove();
            }
            if(a[i]<0)
                queue.add(i);
        }
        //this is for the last window
        if(!queue.isEmpty())
            System.out.print(a[queue.peek()]+" ");
        else
            System.out.print(0+" ");

    }

    //O(n) time,O(1) space
    static void printFirstNegativeInteger(int a[], int k, int n) {
        int firstNegativeIndex = 0;
        int firstNegativeElement;

        for(int i = k - 1; i < n; i++)
        {

            // Skip out of window and positive elements
            while ((firstNegativeIndex < i ) &&
                    (firstNegativeIndex <= i - k ||
                            a[firstNegativeIndex] > 0))
            {
                firstNegativeIndex ++;
            }

            // Check if a negative element is
            // found, otherwise use 0
            firstNegativeElement = Math.min(a[firstNegativeIndex], 0);

            System.out.print(firstNegativeElement + " ");
        }
    }


    //O(nk)
    public static void firstNegative(int[] a,int k,int si){
        if(si==a.length-k+1)
            return;
        int i;
        for(i=si;i<si+k;i++){
            if(a[i]<0){
                System.out.print(a[i]+" ");
                break;
            }

        }
        if(i==(si+k))
            System.out.print(0+" ");
        firstNegative(a,k,si+1);  //O(n-k+1) times into O(k)
    }
}
