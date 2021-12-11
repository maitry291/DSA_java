package DSA_Trees;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
//        GenericTree gtree=new GenericTree();
//        gtree.display();

//        BinaryTree bTree=new BinaryTree();
//        bTree.display();
//        System.out.println("Height of the binary tree is "+bTree.height());

        int[] arr={10,20,30,40,50,60,70};
        BST bst=new BST(arr);

        bst.display();
        System.out.println(bst.findElement(100));
        System.out.println(bst.findMax());

        bst.addNode(55);
        bst.display();

        bst.removeNode(60);
        bst.display();



    }
}
