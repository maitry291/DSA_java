package DSA_Queue;

import DSA_StacksAndQueues.StackUsingArrays;

import java.util.Queue;
import java.util.Stack;

public class implement {
    public static void main(String[] args) {

        /*CircularArrayQueue c=new CircularArrayQueue(5);
        for(int i=1;i<6;i++)
          c.enQueue(i);
       // System.out.println(c);
        System.out.println(c.getFront());
        c.Dequeue();
        System.out.println(c.getFront());

        QueueUsingLL lqueue=new QueueUsingLL();
        for(int i=1;i<6;i++)
            lqueue.enQueue(i);
        while(!lqueue.isEmpty()){
            System.out.println(lqueue.getFirst());
            lqueue.deQueue();
        }*/

        /*StackUsingQueue stack=new StackUsingQueue();
        stack.pushN(1);
        stack.pushN(2);
        stack.pushN(3);


        System.out.println(stack.pop1());
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());*/

        QueueUsingStack queue = new QueueUsingStack();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.display();

        System.out.println(queue.dequeue());
        queue.display();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

    public void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty())
            return;
        int e = queue.remove();
        reverseQueue(queue);
        queue.add(e);
    }



}
