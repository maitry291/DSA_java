package DSA_7_Challanges;
//removes consecutive duplicates.

public class ques5 {
    public static void main(String[] args) {
        System.out.println(removeDuplicate("aabccba",0));
    }
    public static String removeDuplicate(String str,int si){
        if(si==str.length()-1)
            return str;
        if(str.charAt(si)==str.charAt(si+1)){
            str=str.substring(0,si)+str.substring(si+1);
        }
        return removeDuplicate(str,si+1);
    }
}
