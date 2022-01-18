package DSA_Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstRepeatingChar {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> queue=new LinkedList<>();

        Scanner sc=new Scanner(System.in);
        char c=sc.next().charAt(0);

        while (c!='.'){
            queue.add(c);
            if(map.containsKey(c)){
                int ov=map.get(c);
                map.put(c,ov+1);
            }
            else
                map.put(c,1);

            while(!queue.isEmpty()){
                char fc=queue.peek();
                if(map.get(fc)==1) {
                    System.out.println(fc);
                    break;
                }
                else
                    queue.poll();
            }

            if(queue.isEmpty())
                System.out.println(-1);

            c=sc.next().charAt(0);
        }
    }

}
