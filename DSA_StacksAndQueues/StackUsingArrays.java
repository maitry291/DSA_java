package DSA_StacksAndQueues;

public class StackUsingArrays {
    int[] data;
    private int top=-1;
    public static final int DEFAULT_CAPACITY=10;

    //constructor
    public StackUsingArrays() throws Exception{
       this(DEFAULT_CAPACITY);
    }
    public StackUsingArrays(int capacity) throws Exception{
        if(capacity<1)
            throw new Exception("Invalid Capacity");
        else
            this.data=new int[capacity];
    }
    public int size(){
        return this.top+1;
    }
    public boolean isEmpty(){
        return this.size() == 0;
    }
    public void push(int value) throws Exception{
        if(this.size()==this.data.length)
            throw new Exception("Stack is full");
        top++;
        this.data[top]=value;
        //return value;
    }
    public int pop() throws Exception{
        if(this.size()==0)
            throw new Exception("Stack is empty");
        int return_value=this.data[this.top];
        this.data[this.top]=0;
        this.top--;
        return return_value;
    }
    public int top() throws Exception{
        if(this.size()==0)
            throw new Exception("Stack is empty");
        return this.data[this.top];
    }
    public void Display(){
        for(int i=this.top;i>=0;i--){
            System.out.print(this.data[i]+" ");
        }
        System.out.println("END");
    }
}
