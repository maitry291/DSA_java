package DSA_DynamicProgramming;

import java.util.Arrays;

//longest common substring length
public class LCS {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "agcfd";
        System.out.println(findLCS(s1, s2));
        System.out.println(findLCSVidx(s1, s2, 0, 0));
        int[][] s = new int[s1.length()][s2.length()];
        for (int[] ints : s) Arrays.fill(ints, -1);
        System.out.println(findLcsTd(s1, s2, 0, 0, s));
        System.out.println(findLcsBu(s1,s2));
        System.out.println(findLcsBuSpaceEff(s1,s2));
    }

    //time complexity : O(2^(m+n))
    //substring function have complexity in order of n
    public static int findLCS(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty())
            return 0;

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        int ans = 0;

        if (c1 == c2) {
            ans = 1 + findLCS(s1.substring(1), s2.substring(1));
        } else {
            ans = Math.max(findLCS(s1, s2.substring(1)), findLCS(s1.substring(1), s2));
        }
        return ans;
    }

    //time complexity : O(2^(m+n))
    //without using substring function
    public static int findLCSVidx(String s1, String s2, int vidx1, int vidx2) {
        if (s1.length() == vidx1 || s2.length() == vidx2)
            return 0;

        char c1 = s1.charAt(vidx1);
        char c2 = s2.charAt(vidx2);
        int ans = 0;

        if (c1 == c2) {
            ans = 1 + findLCSVidx(s1, s2, vidx1 + 1, vidx2 + 1);
        } else {
            ans = Math.max(findLCSVidx(s1, s2, vidx1, vidx2 + 1), findLCSVidx(s1, s2, vidx1 + 1, vidx2));
        }
        return ans;
    }

    //time complexity : O(m*n) and space complexity : O(m*n) +rec extra space
    public static int findLcsTd(String s1, String s2, int vidx1, int vidx2, int[][] storage) {
        if (s1.length() == vidx1 || s2.length() == vidx2)
            return 0;

        //re use
        if (storage[vidx1][vidx2] != -1)
            return storage[vidx1][vidx2];

        char c1 = s1.charAt(vidx1);
        char c2 = s2.charAt(vidx2);
        int ans = 0;

        if (c1 == c2) {
            ans = 1 + findLcsTd(s1, s2, vidx1 + 1, vidx2 + 1, storage);
        } else {
            ans = Math.max(findLcsTd(s1, s2, vidx1, vidx2 + 1, storage), findLcsTd(s1, s2, vidx1 + 1, vidx2, storage));
        }

        storage[vidx1][vidx2] = ans;   //store

        return ans;
    }

    //O(er*ec) time complexity and space complexity=O(er*ec)
    //bottom up dynamic programming to overcome recursive space
    public static int findLcsBu(String s1, String s2) {
        int[][] storage = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    storage[i][j] = 1 + storage[i + 1][j + 1];
                else
                    storage[i][j] = Math.max(storage[i + 1][j] , storage[i][j + 1]);
            }
        }
        return storage[0][0];
    }

    //time complexity : O(m*n) and space complexity : O(s2.len)
    public static int findLcsBuSpaceEff(String s1, String s2){
        int[] storage=new int[s2.length()+1];

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if(s1.charAt(i)==s2.charAt(j)){
                    storage[j]=storage[j+1]+1;
                }else
                    storage[j]=Math.max(storage[j+1],storage[j]);
            }
        }
        return storage[0];
    }

}
