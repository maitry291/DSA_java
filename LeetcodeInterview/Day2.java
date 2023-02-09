package LeetcodeInterview;

public class Day2 {
    public int singleNumber(int[] nums) {
        int freq=nums[0];
        int i=1,k=1,prev=375643;
        while(i<nums.length){
            if(freq==nums[i]) {
                nums[i]=9999;
                if(nums[k]!=9999) {
                    freq = nums[k];
                }
                else {
                    freq = nums[++i];
                }
                i=++k;
            }
            else i++;
        }
        return freq;
    }

    public int[][] construct2DArray(int[] original, int m, int n) {

        int[][] ans=new int[m][n];
        if(original.length>m*n)
            return new int[][]{};
        int k=0;

        //adding elements in ans
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=original[k];
                k++;
            }
        }
        return ans;
    }
}
