package DSA_LinkedList;

public class userDefinedLL {
    private class Node{
        int data;
        Node next;
    }
    private Node head;
    private Node tail;
    private int size;

    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return getSize()==0;
    }

    public void display(){
        Node temp=this.head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println("end");
    }
    public void addAt(int data,int index){

    }

    //O(1)
    public void addFirst(int data){
        Node nn=new Node();
        nn.data=data;
        //when list is empty
        if(size==0){
          nn.next=null;
          head=nn;
          tail=nn;
        }
        //attach
        else{
           nn.next=head;
           head=nn;
        }
        size++;
    }
    //O(1)
    public void addLast(int data){
       Node nn=new Node();
       nn.data=data;
       nn.next=null;
       if(size==0){
           this.head=nn;
       }
       else{
           tail.next=nn;
       }
       this.tail=nn;
       this.size++;
    }
    //o(n)
    private Node getNodeAt(int index) throws Exception{
        if(this.size==0){
           throw new Exception("list is empty");
        }
        if(index<0||index>=this.size)
            throw new Exception("invalid index");
        Node temp=this.head;
        for(int i=1;i<=index;i++)
            temp=temp.next;
        return temp;
    }
    //o(n)
    public int getAt(int index) throws Exception{
        if(this.size==0){
            throw new Exception("list is empty");
        }
        if(index<0||index>=this.size)
            throw new Exception("invalid index");
        Node temp=this.head;
        for(int i=1;i<=index;i++)
            temp=temp.next;
        return temp.data;
    }
    //o(1)
    public int getFirst() throws Exception{
        if(size==0)
            throw new Exception("list is empty");
        return head.data;
    }
    //o(1)
    public int getLast() throws Exception{
        if(size==0)
            throw new Exception("list is empty");
        return tail.data;
    }
    //o(1)
    public void removeFirst() throws Exception{
        if(size==0)
            throw new Exception("list is empty");
        if(size==1){
            head=null;
            tail=null;
        }
        else
            this.head=head.next;
        size--;
    }
    //o(n)
    public void removeLast() throws Exception{
        if(size==0)
            throw new Exception("list is empty");
        if(size==1){
            head=null;
            tail=null;
        }
        else {
            int idx = size - 1;
            Node n = getNodeAt(idx - 1);
            tail=n;
            n.next = null;
        }
        size--;
    }
    //o(n)
    public void removeAt(int index) throws Exception{
        if(size==0)
            throw new Exception("list is empty");
        if(index<0||index>=this.size)
            throw new Exception("invalid index");
        if(index==0) {
            removeFirst();
            return;
        }
        if(index==size-1) {
            removeLast();
            return;
        }
        Node n1 = getNodeAt(index - 1), n2 = getNodeAt(index + 1);
        n1.next = n2;
        size--;

    }

    public void reverseData() throws Exception {
        int l=0,r=size-1;
        while(l<r){
            Node ln=getNodeAt(l);
            Node rn=getNodeAt(r);

            int temp=ln.data;
            ln.data=rn.data;
            rn.data=temp;

            l++;
            r--;
        }
    }

    public void midPoint(){
        Node temp1=head,temp2=head;
        //int x=0;
        while(temp2.next!=null&&temp2.next.next!=null){
          temp1=temp1.next;
          temp2=temp2.next.next;
        }
        System.out.println(temp1.data);
    }

}
