package DSA_LinkedList;

public class userDefinedStackFromLL {
    private userDefinedLL stack;

    public userDefinedStackFromLL(){
        this.stack=new userDefinedLL();
    }

    public int getSize(){
        return stack.getSize();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void push(int item){
        stack.addFirst(item);
    }
    public void pop() throws Exception {
        stack.removeFirst();
    }
    public void display(){
        this.stack.display();
    }
    public int getTop() throws Exception {
        return stack.getFirst();
    }
}
