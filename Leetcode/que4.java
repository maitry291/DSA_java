package Leetcode;

public class que4 {
    public static void main(String[] args) {
        //plusOne(new int[]{9});
        System.out.println(climbStairs(2));
    }

    public static int climbStairsBU(int n){
        int[] storage=new int[n+1];
        if(n==1)
            return 1;

        storage[1]=1;
        storage[2]=2;

        for(int i=3;i<=n;i++){
            storage[i]=storage[i-2]+storage[i-1];
        }

        return storage[n];
    }

    public static int climbStairs(int n) {

        if(n-2==0)
            return 2;
        if(n-1==0)
            return 1;

        int count=0;

        count=climbStairs(n-1);
        count+=climbStairs(n-2);


        return count;
    }

    public int mySqrt(int x) {
        long mid, low = 0, high = x;

        while (low + 1 < high) {
            mid = (low + high) / 2;
            if (mid * mid == x) {
                return (int) mid;
            }
            if (mid * mid < x) {
                low = mid;
            }
            if (mid * mid > x) {
                high = mid;
            }
        }
        if (high * high == x)
            return (int) high;
        else
            return (int) low;
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        String ans = "";
        char c1, c2;
        while (Math.max(i, j) >= 0) {
            if (i >= 0)
                c1 = a.charAt(i);
            else
                c1 = '0';
            if (j >= 0)
                c2 = b.charAt(j);
            else
                c2 = '0';

            if (carry == 0) {
                if (c1 == '1' && c2 == '1') {
                    ans = "0" + ans;
                    carry = 1;
                }
                if ((c1 == '1' && c2 == '0') || (c1 == '0' && c2 == '1')) {
                    ans = "1" + ans;
                }
                if (c1 == '0' && c2 == '0') {
                    ans = "0" + ans;
                }
            } else {
                if (c1 == '1' && c2 == '1') {
                    ans = "1" + ans;
                } else if ((c1 == '1' && c2 == '0') || (c1 == '0' && c2 == '1')) {
                    ans = "0" + ans;
                    // break;
                } else if (c1 == '0' && c2 == '0') {
                    ans = "1" + ans;
                    carry = 0;
                }
            }
            i--;
            j--;
        }
        if (carry == 1)
            ans = "1" + ans;
        return ans;
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length, all9 = 0;
        int[] ans;
        for (int digit : digits) {
            if (digit == 9)
                all9++;
        }
        if (all9 == n) {
            ans = new int[n + 1];
            ans[0] = 1;
            for (int i = 1; i < ans.length; i++) {
                ans[i] = 0;
            }
            return ans;
        }
        if (digits[n - 1] != 9) {
            digits[n - 1]++;
        } else {
            int c = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] == 9 && c == 1) {
                    digits[i] = 0;
                } else {
                    if (c == 1) {
                        digits[i]++;
                        c = 0;
                    }
                }
            }
        }


        return digits;
    }

    public static int lengthOfLastWord(String s) {
        int i, k = 0;
        for (i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (i < s.length() - 1 && c == ' ' && s.charAt(i + 1) != ' ')
                break;
            if (c != ' ')
                k++;

        }
        return k;
    }
}
