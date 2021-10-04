package DSA_2DArray;

import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {
        int[][] arr=new int[2][3];
        takeInput(arr);
        printArray(arr);

       // int[][] a=new int[][3]; this is not possible.
        int[][] a=new int[3][];  //this will create 3 1D arrays who contains null address initially
        // whose size we have to define further to make 2D array.
        a[0]=new int[4];
        a[1]=new int[6];

        System.out.println(a[2]); //it will print null
        System.out.println(a[0]);   //it will print a valid address.
    }
    public static void takeInput(int[][] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter elements:");
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.printf("element[%d][%d]:",i,j);
                a[i][j]=sc.nextInt();
            }
        }
    }
    public static void printArray(int[][] a){
        System.out.println("Array elements:");
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
