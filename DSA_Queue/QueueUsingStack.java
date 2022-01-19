package DSA_Queue;

import java.util.Queue;
import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> a; //primary stack
    Stack<Integer> b; //secondary stack

    public QueueUsingStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public int size() {
        return this.a.size();
    }

    //O(1)
    //enqueue efficient
    public void enqueue(int data) {
        a.add(data);
    }

    //O(n)
    public int dequeue() {
        //we remove all elements from primary stack till a.size=1
        while (a.size() != 1) {
            b.add(a.pop());
        }
        int x = a.pop(); //store element
        //pop all elements from b to a
        while (!b.isEmpty())
            a.add(b.pop());
        return x;
    }

    //dequeue efficient
    //O(1)
    public int dequeue1(){
        return a.pop();
    }
    //O(n)
    public void enqueueN(int data){
       while(!a.isEmpty()){
           b.add(a.pop());
       }
       a.add(data);
        while(!b.isEmpty()) {
            a.add(b.pop());
        }
    }

    public void display() {
        //reverseStack(a,b,0);
        System.out.println(a);
        //reverseStack(a,b,0);
    }


}
