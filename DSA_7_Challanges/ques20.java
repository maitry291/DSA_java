package DSA_7_Challanges;

public class ques20 {
    public static void main(String[] args) {
       allPossibleWords("123","");
        System.out.println();
        System.out.println(count);
        keypadCode("123","",0);
    }
    static String[] s={"","abc","def","ghi","jkl","mno","prqs","tuv","wx","yz"};
    static int count=0;
    public static void allPossibleWords(String str ,String ans){
        if(str.isEmpty()) {
            count++;
            System.out.print(ans+" ");
            return;
        }

        String s1 = s[Character.getNumericValue(str.charAt(0))];
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            allPossibleWords(str.substring(1),ans+c);
        }
    }
//solution from codingblocks.
    static void keypadCode(String inp, String out, int i) {
        // Base case
        if (i == inp.length()) {
            System.out.print(out + " ");
            count++;
            return;
        }

        // Rec case
        int r = inp.charAt(i) - '0';
        for (int k = 0; k < s[r].length(); k++) {
            char ch = s[r].charAt(k);
            keypadCode(inp, out + ch, i + 1);
        }
    }
}
