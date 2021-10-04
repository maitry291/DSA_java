package DSA_Queue;

import java.util.LinkedList;

public class QueueUsingLL {
    private LinkedList<Integer> queue;

    public QueueUsingLL(){
        this.queue=new LinkedList<>();
    }
    public boolean isEmpty(){
        return this.queue.isEmpty();
    }
    public void enQueue(int data){
        queue.addLast(data);
    }
    public void deQueue(){
        queue.removeFirst();
    }
    public int getFirst(){
        return queue.getFirst();
    }
}
