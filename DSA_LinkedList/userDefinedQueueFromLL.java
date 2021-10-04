package DSA_LinkedList;
//Queue has a property that elements can be added in it at last only and elements can remove from first only.

public class userDefinedQueueFromLL {
    private userDefinedLL queue;

    ///constructor
    public userDefinedQueueFromLL(){
        this.queue=new userDefinedLL();
    }

    public int getSize(){
        return queue.getSize();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public void enQueue(int item){
        this.queue.addLast(item);
    }
    public void deQueue() throws Exception {
        this.queue.removeFirst();
    }
    public int getFront() throws Exception {
        return queue.getFirst();
    }
    public void display(){
        queue.display();
    }

}
