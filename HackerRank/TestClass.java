package HackerRank;

import java.util.List;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) throws Exception {
        //Sample code to perform I/O:
       /* Scanner s = new Scanner(System.in);
        int t, n, k, i;
        t = s.nextInt();
        for (i = 0; i < t; i++) {
            n = s.nextInt();
            k = s.nextInt();
            while (k > n) {
                k = k - n;
            }
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = s.nextInt();
            }
            rotateArray(arr, k);
        }
        s.close();*/
        System.out.println(timeConversion("01:09:45 PM"));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int max = candles.get(0), n = 0;

        for (int i : candles) {
            if (i > max) {
                max = i;
            }
        }
        for (int i : candles) {
            if (i == max) {
                n++;
            }
        }
        return n;
    }

    public static String timeConversion(String s) {
        // Write your code here
        char c0=s.charAt(0);
        char c1=s.charAt(1);
        char c=s.charAt(s.length()-2);
        if(c0=='1'&&c1=='2'&&c=='A'){
            s="00"+s.substring(2);
        }
        if(c=='P'){
            if(c0!='1'||c1!='2'){
                String str=s.substring(0,2);
                int t=Integer.parseInt(str)+12;
                s=t+s.substring(2);
            }
        }

        return s;
    }


    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        long sum = 0;
        for (Long aLong : ar) {
            sum += aLong;
        }
        return sum;
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int min = arr.get(0), max = arr.get(0), sum = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > max)
                max = arr.get(i);
            if (arr.get(i) < min)
                min = arr.get(i);
            sum += arr.get(i);
        }
        int minSum = sum - max, maxSum = sum - min;
        System.out.println(minSum + " " + maxSum);
    }

    public static void rotateArray(int[] a, int k) {
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        int i;
        for (i = 0; i <= k && i + k < a.length; i++)
            a[i + k] = b[i];
        for (int j = 0; j < a.length && i < a.length; j++, i++)
            a[j] = b[i];

        for (int j : a) System.out.print(j + " ");
    }
}

