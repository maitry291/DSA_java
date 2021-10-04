package DSA_Queue;
//cs=current size,ms=maximum size,front index,rear index.

public class CircularArrayQueue {
    private int[] a;
    private int cs,ms,rear,front;
    public final static int initial_capacity=10;

    //constructors
    public CircularArrayQueue(){
        this(initial_capacity);
    }
    public CircularArrayQueue(int capacity){
        this.a=new int[capacity];
        this.cs=0;
        this.ms=capacity;
        this.front=0;
        this.rear=capacity-1;
    }

    //methods
    public boolean isEmpty(){
        return this.cs==0;
    }
    public boolean isFull(){
        return this.ms==this.cs;
    }
    public void enQueue(int data){
        if(!this.isFull()) {
            rear = (rear + 1) % this.a.length;
            a[rear] = data;
            this.cs++;
        }
    }
    public void Dequeue(){
        if(!this.isEmpty()) {
            front = (front + 1) % this.a.length;
            this.cs--;
        }
    }
    public int getFront(){
        return this.a[this.front];
    }

}

