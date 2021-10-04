package DSA_LinkedList;

public class client {
    public static void main(String[] args) throws Exception {

        userDefinedStackFromLL stackFromLL=new userDefinedStackFromLL();
        stackFromLL.push(10);
        stackFromLL.display();
        stackFromLL.push(20);
        stackFromLL.display();
        stackFromLL.push(30);
        stackFromLL.display();
        stackFromLL.push(40);
        stackFromLL.display();
        stackFromLL.push(50);
        stackFromLL.display();

        stackFromLL.pop();
        stackFromLL.display();
/*
        userDefinedQueueFromLL queue=new userDefinedQueueFromLL();
        queue.enQueue(10);
        queue.display();
        queue.enQueue(20);
        queue.display();
        queue.enQueue(30);
        queue.display();
        queue.enQueue(40);
        queue.display();
        queue.deQueue();
        queue.display();

        System.out.println(queue.getSize());
        System.out.println(queue.getFront());
*/

       /* userDefinedLL list=new userDefinedLL();
        list.display();
        list.addLast(10);
        list.addLast(20);


        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.midPoint();
        list.display();
        list.removeFirst();
        list.removeAt(0);
        list.display();
        list.reverseData();
        list.display();

       System.out.println(list.getAt(1));

        System.out.println(list.getFirst());
        System.out.println(list.getLast());*/
    }
}
