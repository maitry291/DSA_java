package DSA_HashMaps;

import DSA_Tries.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class demo {
    public static void main(String[] args) throws Exception {
        /*GenericLL<Integer> l=new GenericLL<>();
        l.addFirst(12);
        System.out.println(l.findElement(12));
        System.out.println(getMostFrequentCharacter("aaabcdbbb"));

        int[] a1={5,1,3,4,7};
        int[] a2={2,4,3,5,7,10,15};
        System.out.println(getIntersection(a1,a2));*/
        HashTable<String,Integer> hashmap=new HashTable<>(2);
        hashmap.put("singapore",50);
        hashmap.put("paris",125);
        hashmap.display();
        hashmap.put("los angles",150);
        hashmap.put("singapore",70);
        hashmap.put("singa",70);
        hashmap.put("pore",70);

        hashmap.display();

        //System.out.println(hashmap.get("singapore"));
        //hashmap.remove("singapore");
        //hashmap.display();
    }
    //O(n) complexity
    public static char getMostFrequentCharacter(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                int x=map.get(c);
                map.put(c,++x);
            }
            else
             map.put(c,1);
        }
        //to find max occurring character
        int max=0;
        char maxChar='\0';
        Set<Map.Entry<Character,Integer>> entries=map.entrySet();
        for(Map.Entry<Character,Integer> entry:entries){
            if(entry.getValue()>max){
                max=entry.getValue();
                maxChar=entry.getKey();
            }
        }
        return maxChar;
    }

    public static ArrayList<Integer> getIntersection(int[] a1, int[] a2){
        HashMap<Integer,Integer> count=new HashMap<>();
        ArrayList<Integer> intersection=new ArrayList<>();
        //traversing first array
        for (int j : a1) {
            count.put(j, 1);
        }
        for(int i:a2){
            if(count.containsKey(i)){
                intersection.add(i);
            }
        }
        return intersection;
    }

}
