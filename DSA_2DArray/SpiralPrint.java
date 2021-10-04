package DSA_2DArray;

public class SpiralPrint {
    public static void main(String[] args) {
        int[][] array={{1,2,3},{4,5,6},{7,8,9}};
        int top=0,bottom=array.length-1,left=0,right=array[top].length-1,dir=1;
        int count=(bottom+1)*(right+1);
        while(top<=bottom&&left<=right){
            if(count>0){
                if(dir==1){
                    for(int i=top;i<=right;i++) {
                        System.out.print(array[top][i] + " ");
                        count--;
                    }
                    top++;
                    dir=2;
                }
            }
            if(count>0){
                if(dir==2){
                    for(int i=top;i<=bottom;i++) {
                        System.out.print(array[i][right] + " ");
                        count--;
                    }
                    right--;
                    dir=3;
                }
            }
            if(count>0){
                if(dir==3){
                    for(int i=right;i>=left;i--) {
                        System.out.print(array[bottom][i] + " ");
                        count--;
                    }
                    bottom--;
                    dir=4;
                }
            }
            if(count>0){
                if(dir==4){
                    for(int i=left;i<=right;i++) {
                        System.out.print(array[top][i] + " ");
                        count--;
                    }
                    left++;
                    dir=1;
                }
            }
        }
    }
}

