package DSA_Trees;

//from given array we have many ways to construct a bst, but we have to choose a way which is efficient.
//one of the way is we can make the first/last element of array as root node, so when we do this way the bst will be
// left /right skewed according to the sorting (increasing/decreasing).
//In the left/right skewed bst complexity for searching any element becomes in the order of n.

//Another way is to make the mid-element as root node, so the resulting bst will be balanced.Hence, complexity
//of searching any element becomes in the order of log n.(can say the best way)

public class BST {

    private static class Node{
        int data;
        Node left;
        Node right;

        //constructor
        Node(int data, Node left, Node right) {
            //in the binary tree each node can have maximum of 2 children which can be either left or right.
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private Node root;
   // private int size=0;

    //we will construct binary search tree from given sorted array by the user.
    public BST(int[] arr){
        this.root=bstConstructor(arr,0, arr.length-1);
    }

    private Node bstConstructor(int[] arr,int l,int h){

        if(l>h){
            return null;
        }

        int mid=(l+h)/2;

        //new node
        Node nn=new Node(arr[mid],bstConstructor(arr,l,mid-1),bstConstructor(arr,mid+1,h));

        return nn;
    }

    public void display(){
        this.display(this.root);
    }
    private void display(Node root){
        String str="";
        if(root.left!=null){
            str+=root.left.data+"->";
        }
        else {
            str+="END->";
        }
        str+=root.data;
        if(root.right!=null){
            str+="<-"+root.right.data;
        }
        else {
            str+="<-END";
        }
        System.out.println(str);

        //recursive call for all nodes
        if(root.left!=null)
            display(root.left);
        if(root.right!=null)
            display(root.right);

    }

    public boolean findElement(int data){
        return findElement(this.root,data);
    }
    private boolean findElement(Node root,int data){
        if(root==null)
            return false;
        if(root.data<data){
           return findElement(root.right,data);
        }
        else if(root.data>data){
           return findElement(root.left,data);
        }
        else
            return true;
    }

    public int findMax(){
        return findMax(this.root);
    }
    private int findMax(Node root){
        if(root.right==null)
            return root.data;
        return findMax(root.right);
    }

    public void addNode(int data){
        addNode(this.root,data);
    }
    private void addNode(Node root,int data){

        if(data> root.data){
            if(root.right==null){
               root.right=new Node(data,null,null);
            }else
               addNode(root.right,data);
        }
       else{
            if(root.left==null){
                root.left=new Node(data,null,null);
            }else
                addNode(root.left,data);
        }
    }

    public void removeNode(int data){
        removeNode(this.root,data);
    }
    private void removeNode(Node root,int data){

        if(data> root.data){
            if(root.right.data==data){
                root.right=null;
            }else
            removeNode(root.right,data);
        }
        else {
            if(root.left.data==data){
                root.left=null;
            }else
            removeNode(root.left, data);
        }
    }

}
