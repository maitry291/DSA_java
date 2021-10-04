package DSA_9_Challanges;
//

public class que6 {
    public static void main(String[] args) {
         removeDuplicateCombination("aab","");
    }
    public static void removeDuplicateCombination(String que,String ans){

        if (que.isEmpty()) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < que.length(); i++) {

            char ch = que.charAt(i);
            String roq = que.substring(0, i) + que.substring(i + 1);

            boolean flag = true;

            for (int j = i + 1; j < que.length(); j++) {
                if (que.charAt(j) == ch) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                removeDuplicateCombination(roq, ans + ch);
        }

    }
}
