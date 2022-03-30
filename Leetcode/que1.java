package Leetcode;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class que1 {
    public static void main(String[] args) {
        //System.out.println(romanToInt("IV"));
        String[] a = {"flower", "flower", "flower","flower"};
        System.out.println(longestCommonPrefix(a));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if ((c == ')' || c == ']' || c == '}')) {
                if (stack.empty())
                    return false;
                char c1 = stack.pop();
                if (c == ')' && c1 == '(')
                    continue;
                if (c == ']' && c1 == '[')
                    continue;
                if (c == '}' && c1 == '{') {
                    continue;
                } else
                    return false;

            }
        }
        return stack.empty();
    }

    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        for (int i = 0; i < strs[0].length() ; i++) {
            if (!isSame(i, strs)) {
                break;
            } else {
                ans += strs[0].charAt(i);
            }
        }
        return ans;
    }

    public static boolean isSame(int i, String[] arr) {
        for (int l = 0; l < arr.length-1; l++) {
            if(i>=arr[l].length()||i>=arr[l+1].length())
                return false;
            char c1 = arr[l].charAt(i);
            char c2 = arr[l + 1].charAt(i);
            if (c1 != c2)
                return false;
        }

        return true;
    }

    public static String longestCommonSubsequnce(String[] strs) {
        String ans = "";
        if (strs.length == 1)
            return strs[0];
        for (int i = 0; i < strs.length - 1; i++) {
            ans = "";
            String s1 = strs[i];
            String s2 = strs[i + 1];
            int l = Math.min(s1.length(), s2.length());
            for (int j = 0; j < l; j++) {
                if (s1.charAt(j) != s2.charAt(j))
                    break;
                else
                    ans += s1.charAt(j);
            }
        }
        return ans;
    }

    public static int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int ith = 0;

        while (ith < s.length()) {
            char c1 = s.charAt(ith);
            if (ith == s.length() - 1) {
                ans += roman.get(c1);
                break;
            } else {
                char c2 = s.charAt(ith + 1);
                if (roman.get(c2) <= roman.get(c1)) {
                    ans += roman.get(c1);
                    ith++;
                }
                if (roman.get(c2) > roman.get(c1)) {
                    ans += roman.get(c2) - roman.get(c1);
                    ith = ith + 2;
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int rev = 0, k = x;
        while (k != 0) {
            int rem = k % 10;
            rev = rev * 10 + rem;
            k = k / 10;
        }
        return x == rev;
    }

    public int scoreOfParentheses(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
        }
        return count;
    }
}
