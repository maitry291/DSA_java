package DSA_Queue;

public class implement {
    public static void main(String[] args) {
        CircularArrayQueue c=new CircularArrayQueue(5);
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
        }
    }
}
