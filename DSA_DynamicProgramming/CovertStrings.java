package DSA_DynamicProgramming;

import java.util.Arrays;

public class CovertStrings {
    public static void main(String[] args) {
        String s1="saturdayanfjkfbolgoknlhnhmdkjftb";
        String s2="sundayjsxsijfdfjgldkdlsksslklfljbgl";
        //System.out.println(getOperations(s1,s2,0,0));
        int[][] s = new int[s1.length()][s2.length()];
        for (int[] ints : s) Arrays.fill(ints, -1);
        System.out.println(getOperationsTd(s1,s2,0,0,s));
        System.out.println(getOperationsBu(s1,s2));
        //System.out.println(getOperationsBuSe(s1,s2));
    }

    //we are finding minimum number of operations(Insertion/deletion/replace) to convert string s2 into s1.

    //time complexity : O(3^(m+n))
    public static int getOperations(String s1,String s2,int i1,int i2){
        //base case
        if (s1.length() == i1 || s2.length() == i2)
            return Math.max(s1.length()-i1,s2.length()-i2);


        char c1=s1.charAt(i1);
        char c2=s2.charAt(i2);

        int count=0;

        if(c1==c2){
            count=getOperations(s1,s2,i1+1,i2+1);
        }else{
            int x=getOperations(s1,s2,i1+1,i2);   //insertion case
            int y=getOperations(s1,s2,i1,i2+1);   //deletion case
            int z=getOperations(s1,s2,i1+1,i2+1);   //replace case

            count=Math.min(x,Math.min(y,z))+1;
        }

        return count;
    }

    //time complexity : O(m*n) , Space complexity : O(m*n) + rec extra space
    public static int getOperationsTd(String s1,String s2,int i1,int i2,int[][] storage){
        //base case
        if (s1.length() == i1 || s2.length() == i2)
            return Math.max(s1.length()-i1,s2.length()-i2);

        //re use
        if(storage[i1][i2]!=-1)
            return storage[i1][i2];

        char c1=s1.charAt(i1);
        char c2=s2.charAt(i2);

        int count=0;

        if(c1==c2){
            count=getOperationsTd(s1,s2,i1+1,i2+1,storage);
        }else{
            int x=getOperationsTd(s1,s2,i1+1,i2,storage);   //insertion case
            int y=getOperationsTd(s1,s2,i1,i2+1,storage);   //deletion case
            int z=getOperationsTd(s1,s2,i1+1,i2+1,storage);   //replace case

            count=Math.min(x,Math.min(y,z))+1;
        }

        //store
        storage[i1][i2]=count;

        return count;
    }

    //time complexity : O(m*n) , Space complexity : O(m*n)
    public static int getOperationsBu(String s1,String s2){
        int[][] storage = new int[s1.length()+1][s2.length()+1];

        //base case values
        for(int col=0;col<s2.length();col++)
            storage[s1.length()][col]=s2.length()-col;
        for(int row=0;row<s1.length();row++)
            storage[row][s2.length()]=s1.length()-row;

        for (int i = s1.length()-1 ; i >=0; i--) {
            for (int j = s2.length()-1 ; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    storage[i][j] = storage[i + 1][j + 1];
                else
                    storage[i][j] = 1+Math.min(storage[i + 1][j] ,Math.min(storage[i][j + 1],storage[i + 1][j + 1]));
            }
        }

        return storage[0][0];
    }

    //in complete
    public static int getOperationsBuSe(String s1,String s2){
        int[] storage = new int[s2.length()+1];

        for(int i=0;i<storage.length;i++){
            storage[i]=s2.length()-i;
        }
        int y=0;
        for(int i=s1.length()-1;i>=0;i--){
            for (int j = s2.length()-1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j))
                    storage[j] = storage[j + 1];
                else{
                    int x=storage[j+1];   //diagonal
                    if(j==s2.length()-1) {
                        ++storage[j + 1];
                        y = storage[j + 1];   //next col
                    }
                    int z=storage[j];
                    y=Math.min(x,Math.min(y,z));
                    storage[j]=1+y;
                }

            }
        }
        return storage[0];
    }
}
