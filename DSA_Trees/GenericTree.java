package DSA_Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
    //constructing class node for tree
    private static class Node{
        int data;
        //as generic tree can have any number of children, so we will need an arraylist to store it.
        ArrayList<Node> children;
        Node(int data){
            this.data=data;
            this.children=new ArrayList<>();
        }
    }
    //declaring root node
    Node root;
    private int size;
    //constructor of generic tree
    GenericTree(){
        Scanner s=new Scanner(System.in);
        this.root=takeInput(s,null,0);
    }
    public Node takeInput(Scanner s,Node parent,int ithChild){
        if(parent==null){
            System.out.println("Enter the data of root node : ");
        }
        else {
            System.out.println("Enter the data for "+ithChild+"th child of parent node "+parent.data+" : ");
        }
        //after giving the enter node line we have to take input of that node.
        int nodeData=s.nextInt();
        Node node=new Node(nodeData);
        //so size of the tree will increase
        this.size++;

        //after taking input of node we have to ask the user that he wants children of that node or not.
        System.out.println("enter the number of children for "+node.data+" : ");
        int children = s.nextInt();

        //taking children of the node and then attaching it to the root node
        for(int i=0;i<children;i++){
            //makes children node
            Node child=this.takeInput(s,node,i);
            //attaches to the root node.
            node.children.add(child);
        }
        return node;
    }
    public void display(){
        this.display(this.root);
    }

    private void display(Node root){
        String str=root.data+" -> ";
        for (int i=0;i<root.children.size();i++) {
           str+=root.children.get(i).data+" ,";
        }
        str+=" END";
        System.out.println(str);
        for (int i=0;i<root.children.size();i++) {
            this.display(root.children.get(i));
        }
    }

}
