package DSA_7_Challanges;

public class ques13 {
    public static void main(String[] args) {
        System.out.println(moveAllx("axbxc",0));
    }
    public static String  moveAllx(String str,int si){
        if(si==str.length()-1)
            return str;
        if(str.charAt(si)=='x'){
            str=str.substring(0,si)+str.substring(si+1)+"x";
        }
       return moveAllx(str,si+1);
    }
}
