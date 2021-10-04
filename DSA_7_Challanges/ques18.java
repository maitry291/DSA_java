package DSA_7_Challanges;

public class ques18 {
    public static void main(String[] args) {
        keypad1("12","");
    }
    static String[] table = { " ", ".+@$", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

   public static void keypad1(String str,String ans){
       if(str.isEmpty()) {
           System.out.println(ans);
           return;
       }
       String s1 = table[Character.getNumericValue(str.charAt(0))];
       for(int i=0;i<s1.length();i++){
           char c=s1.charAt(i);
           keypad1(str.substring(1),ans+c);
       }
   }

}
