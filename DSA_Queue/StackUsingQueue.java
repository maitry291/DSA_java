package DSA_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackUsingQueue {
    //2 queue one will be primary and other is secondary
    Queue<Integer> a;  //primary (we do all main operations on primary queue like add/remove)
    Queue<Integer> b;   //secondary queue

    public StackUsingQueue(){
        a=new LinkedList<>();
        b=new LinkedList<>();
    }

    //O(1)
    //push efficient
    public void push(int data){
        a.add(data);
    }

    //O(n)
    public int pop(){
        //we remove all elements from primary queue till a.size=1
        //and then swap both queues and returns the last element
        while (a.size()!=1){
            b.add(a.remove());
        }
        //swap queues
        Queue<Integer> temp=a;
        a=b;
        b=temp;
        return b.remove();
    }

    //O(n)
    //pop efficient
    public void pushN(int data){
        //add in secondary queue
        b.add(data);
        //if a/primary queue is not empty,remove all elements from primary/a queue and add in secondary/b
        while(!a.isEmpty()){
            b.add(a.remove());
        }
        //swap queues
        Queue<Integer> temp=a;
        a=b;
        b=temp;
    }
    //O(1)
    public int pop1(){
        return a.remove();
    }



    public void display(){

    }

}
