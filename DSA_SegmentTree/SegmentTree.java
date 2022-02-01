package DSA_SegmentTree;

//we perform both the operations i.e. calculate sum of given interval
// and change the any array element in O(log n) time once given the array

//tree will be a Full Binary Tree because we always divide segments in
//two halves at every level. Since the constructed tree is always a full binary tree with n leaves,
//there will be n-1 internal nodes and n leaf nodes So the total number of nodes will be n+n-1=2*n-1 nodes.

// Height of the segment tree will be ⌈log₂n⌉
//size of memory allocated for segment tree will be 2 * 2⌈log2n⌉  – 1.

public class SegmentTree {

    private static class Node{
        int si,li;
        Node left,right;
        int data;

    }

    private final Node root;

    public SegmentTree(int[] arr){
         this.root=constructTree(arr,0,arr.length-1);
     }

    private Node constructTree(int[] a,int si,int li) {
         if(si==li){
             Node leafNode =new Node();
             leafNode.si=si;
             leafNode.li=si;
             leafNode.data=a[si];
             return leafNode;
         }

         int mid=(si+li)/2;
         Node root=new Node();
         root.si=si;
         root.li=li;
         root.left=constructTree(a,si,mid);
         root.right=constructTree(a,mid+1,li);

         root.data=root.left.data+root.right.data;

         return root;
    }

    public void display(){

        display(this.root);
        System.out.println("--------------------------------------------------");
    }
    //pre order traversal
    private void display(Node root){
         if(root==null)
             return;

        System.out.println("["+root.si+","+ root.li+"]"+"sum="+root.data);

        display(root.left);
        display(root.right);
    }

    public int getSum(int si,int li){
        return getSum(this.root,si,li);
    }
    private int getSum(Node parent,int si,int li){

        //when interval of query is not between parent interval
        if(parent.si>li||parent.li<si)
            return 0;
        else if(parent.si>=si&&parent.li<=li){  //inside query interval
            return parent.data;
        }else {
            //overlapping case
            int leftSum=getSum(parent.left,si,li);
            int rightSum=getSum(parent.right,si,li);

            return leftSum+rightSum;
        }
    }

    public void updateElement(int index,int ele){ updateElement(root,index,ele);}

    private void updateElement(Node parent,int index,int ele){
        if(parent.si>index||index> parent.li){
            return;
        }
        if(parent.si==index&&parent.li==index){
            parent.data=ele;
            return;
        }
        updateElement(parent.left,index,ele);
        updateElement(parent.right,index,ele);

        parent.data=parent.left.data+ parent.right.data;

    }
}
