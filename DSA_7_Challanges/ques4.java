package DSA_7_Challanges;
//adds "*" between two consecutive duplicates.

public class ques4 {
    public static void main(String[] args) {
        System.out.println(duplicate("hello",0));
    }
    public static String duplicate(String str,int si){
        if(si==str.length()-1)
            return str;
        if(str.charAt(si)==str.charAt(si+1)){
            str=str.substring(0,si+1)+"*"+str.substring(si+1);
        }
       return duplicate(str,si+1);
    }
}
