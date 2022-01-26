package DSA_DynamicProgramming;

import java.util.Arrays;

public class MazePathDiagonal {
    public static void main(String[] args) {
        int n=34;
        //System.out.println(mazePathDiagonal(0,0,n,n));
        System.out.println(mazePathDiaTd(0,0,n,n,new int[n+1][n+1]));
        System.out.println(mazePathBu(n,n));
        System.out.println(mazePathBuSpaceEffi(n,n));
    }

    //O(3^(er+ec)) time complexity
    public static int mazePathDiagonal(int sr,int sc,int er,int ec){
        //-ve base case
        if (sr > er || sc > ec) {
            return 0;
        }
        //+ve base case
        if (sr == er && sc == ec) {
            return 1;
        }
        int count = 0;
        count += mazePathDiagonal(sr, sc + 1, er, ec);
        count += mazePathDiagonal(sr + 1, sc, er, ec);
        count+=mazePathDiagonal(sr+1,sc+1,er,ec);

        return count;
    }

    //O(er*ec) time complexity and space comp=O(er*ec)+recursion extra space
    public static int mazePathDiaTd(int sr,int sc,int er,int ec,int[][] storage){
        //-ve base case
        if (sr > er || sc > ec) {
            return 0;
        }
        //+ve base case
        if (sr == er && sc == ec) {
            return 1;
        }
        //re use
        if(storage[sr][sc]!=0)
            return storage[sr][sc];

        int count = 0;
        count += mazePathDiaTd(sr, sc + 1, er, ec,storage);
        count += mazePathDiaTd(sr + 1, sc, er, ec,storage);
        count += mazePathDiaTd(sr + 1, sc+1, er, ec,storage);

        storage[sr][sc]=count;   //store

        return count;
    }

    //O(er*ec) time complexity and space complexity=O(er*ec)
    //bottom up dynamic programming to overcome recursive space
    public static int mazePathBu(int er,int ec){
        int[][] storage=new int[er+2][ec+2];

        storage[er][ec] = 1;  //base case

        for (int i = er; i >= 0; i--) {
            for (int j = ec; j >= 0; j--) {
                if (i == er && j == ec)
                    continue;
                storage[i][j] = storage[i + 1][j] + storage[i][j + 1]+storage[i+1][j+1];
            }
        }

        return storage[0][0];
    }

    //O(er*ec) time complexity and space complexity=O(ec)
    public static int mazePathBuSpaceEffi(int er,int ec){
        int[] storage=new int[ec+1];
        Arrays.fill(storage,1);

        int temp=1;
        for (int i = er; i > 0; i--) {
            for(int j=ec-1;j>=0;j--){
                int val=storage[j]+storage[j+1]+temp;
                temp=storage[j];
                storage[j]=val;
            }
            temp=1;
        }
        return storage[0];
    }
}
