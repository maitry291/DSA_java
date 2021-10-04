package DSA_StacksAndQueues;

public class DynamicStack extends StackUsingArrays {
    public DynamicStack() throws Exception {
       this(DEFAULT_CAPACITY);
    }
    public DynamicStack(int capacity) throws Exception {
       super(capacity);
    }

    @Override
    public void push(int value) throws Exception {
      if(this.size()==this.data.length){
          int[] array=new int[2*this.data.length];
          for(int i=0;i<this.data.length;i++){
              array[i]=this.data[i];
          }
          this.data=array;
      }
      super.push(value);
    }
}
