package DSA_2DArray;

public class WavePrint {
    public static void main(String[] args) {
        int[][] array={{1,2},{4,5,6},{7,8,9}};
        System.out.println("Array elements in wave style:");
        for(int i=0;i< array.length;i++){
            if(i%2==0) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
            }
            if(i%2==1){
                for (int j =array[i].length-1; j>=0; j--) {
                    System.out.print(array[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}
