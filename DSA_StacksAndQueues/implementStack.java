package DSA_StacksAndQueues;

public class implementStack {
    public static void main(String[] args) throws Exception {
        StackUsingArrays stack=new StackUsingArrays(5);
        System.out.println(stack.size());
        stack.push(20);
        stack.pop();
       //int[] a= stack.data;

        for(int i=1;i<5;i++){
            stack.push(i*10);
            stack.Display();
        }

        //using dynamic stack
        StackUsingArrays stack1=new DynamicStack(5);
        System.out.println(stack1.size());
        stack1.push(20);
        stack1.pop();

        for(int i=1;i<10;i++){
            stack1.push(i*10);
            stack1.Display();
        }
    }
}
