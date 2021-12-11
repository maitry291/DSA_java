package DSA_Trees;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

    private static class Node{
        int data;
        Node left;
        Node right;

        //constructor
        Node(int data,Node left,Node right) {
            //in the binary tree each node can have maximum of 2 children which can be either left or right.
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private Node root;
    private int size=0;

    //binary tree constructor
    BinaryTree(){
        Scanner s=new Scanner(System.in);
        this.root=takeInput(s,null,false);
    }
    //isLeftOrRight is true when node will have left node and false when node will have right node.
    private Node takeInput(Scanner s,Node parent,boolean isLeftOrRight){
        if(parent==null){
            System.out.print("Enter the data for the root node : ");
        }
        else {
            if(isLeftOrRight){
                System.out.print("Enter the data of left child for the node "+parent.data+" : ");
            }
            else {
                System.out.print("Enter the data of right child for the node "+parent.data+" : ");

            }

        }
        int nodeData=s.nextInt();
        Node node= new Node(nodeData,null,null);
        this.size++;

        boolean choice=false;
        System.out.print("Do you want left child of "+nodeData+" ? ");
        choice=s.nextBoolean();
        if(choice){
            node.left=takeInput(s,node,true);
        }
        choice=false;
        System.out.print("Do you want right child of "+nodeData+" ? ");
        choice=s.nextBoolean();
        if(choice){
            node.right=takeInput(s,node,false);
        }

        return node;

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

    public int height(){
        return height(this.root);
    }

    private int height(Node root){
        //base case
        if(root==null){
          return -1;  //we wre not giving 0 imp step
        }

        int lHeight=height(root.left);
        int rHeight=height(root.right);

        return Math.max(lHeight,rHeight)+1;
    }

    //pre-order means -> node,left,right
    public void preOrderTraversal(){
        preOrderTraversal(this.root);
    }
    private void preOrderTraversal(Node root){
        if(root==null)
            return;

        System.out.print(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
    //in-order means ->left node right
    public void inOrderTraversal(){
        inOrderTraversal(this.root);
    }
    private void inOrderTraversal(Node root){
        if(root==null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data);
        inOrderTraversal(root.right);

    }
    //post-order means ->left right node
    public void postOrderTraversal(){
        postOrderTraversal(this.root);
    }
    private void postOrderTraversal(Node root){
        if(root==null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data);

    }
    //same level traversal
    //understand this self
    public void levelTraversal(){
        this.levelTraversal(this.root);
    }
    private void levelTraversal(Node root){
        LinkedList<Node> queue=new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()){
            Node rv=queue.removeFirst();
            System.out.print(rv.data+" ");
            if(rv.left!=null){
                queue.addLast(rv.left);
            }
            if(rv.right!=null){
                queue.addLast(rv.right);
            }
        }

    }


}
