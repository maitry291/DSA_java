package LeetcodeInterview;

import java.util.*;

public class Day1 {

    //public int countVowelSubstrings(String word) {

    //}
    class pair{
        int data;
        int freq;
        public pair(int data,int freq){
            this.data=data;
            this.freq=freq;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<String> s=new Stack<>();

        for(String x:tokens){
            if(!s.empty()&& Objects.equals(x, "+")){
               int ans=Integer.parseInt(s.pop())+Integer.parseInt(s.pop());
               s.push(String.valueOf(ans));
               continue;
            }
            if(!s.empty()&& Objects.equals(x, "*")){
                int ans=Integer.parseInt(s.pop())*Integer.parseInt(s.pop());
                s.push(String.valueOf(ans));
                continue;
            }
            if(!s.empty()&& Objects.equals(x, "/")){
                int a1=Integer.parseInt(s.pop()),a2=Integer.parseInt(s.pop());
                int ans=a2/a1;
                s.push(String.valueOf(ans));
                continue;
            }
            if(!s.empty()&& Objects.equals(x, "-")){
                int a1=Integer.parseInt(s.pop()),a2=Integer.parseInt(s.pop());
                int ans=a2-a1;
                s.push(String.valueOf(ans));
                continue;
            }

            s.push(x);
        }
        return Integer.parseInt(s.peek());
    }

    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0,j=s.length()-1;
        while(i!=j){
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(c1!=c2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[nums.length];

        for(int x:nums){
            if(map.containsKey(x)){
                int v=map.get(x)+1;
                map.put(x,v);
            }
            else
                map.put(x,1);
        }


        PriorityQueue<pair> h=new PriorityQueue<>(Comparator.comparingInt(p -> p.freq));

        for(int j:map.keySet()){
            pair p=new pair(j,map.get(j));
            h.add(p);
        }
        int i=0;
        while(!h.isEmpty()){
           pair p=h.remove();
           while(i<nums.length && p.freq!=0){
               ans[i++]=p.data;
               p.freq--;
           }
        }

        return ans;

    }


    public static void main(String[] args) {
        Deque<Integer> heap=new LinkedList<>();

        //heap.peek();
        PriorityQueue<Integer> h=new PriorityQueue<>(Collections.reverseOrder());

    }

    public int firstUniqChar(String s) {
        HashMap<Character,Integer> q=new HashMap<>();


        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(q.containsKey(c)) {
                q.remove(c);
            }
            else {
                q.put(c, i);
            }
        }
        int min=s.length();
        for(int x:q.values()){
            if(x<min){
                min=x;
            }
        }
        if(min==s.length())
            return -1;
        return min;
    }
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;

        for(int i=0;i<nums.length;i++){
            map.put(i,nums[i]);
        }
        for(int i=0;i<map.size();i++){
            map.get(i);
        }
        return l;
    }

    public int braces(String a) {
       Stack<Character> t=new Stack<>();
       t.clear();
       int i=0;
       while(i<a.length()){
           if(a.charAt(i)==')'&&!t.empty()){
               t.pop();
               if(!t.empty())
                  t.pop();


           }else {
               if(a.charAt(i)=='+'||a.charAt(i)=='-'||a.charAt(i)=='*'||a.charAt(i)=='/'||a.charAt(i)=='(')
                   t.push(a.charAt(i));
           }
           i++;
       }
       if(t.empty())
           return 0;
       return 1;
    }

    public int solve(String a) {
        Stack<Character> t=new Stack<>();

        int i=0;
        while(i<a.length()){
            if(a.charAt(i)==')') {
                if(t.empty())
                    return 0;
                t.pop();
            }
            else
                t.push(a.charAt(i));
            i++;
        }
        if(t.empty())
            return 1;
        else
            return 0;
    }

    public static String fun(List<String> root, String msg){
        //root.remove(new Object())
        int i=0,j=0;
        boolean found;
        String ans= "";
        ans.contains("");
        

        Collections.sort(root);
        while(i<msg.length()){
            if (msg.charAt(i) == ' '||i==msg.length()-1) {
                found=false;
                String s;
                if(i==msg.length()-1){
                    s=msg.substring(j);
                }else
                    s=msg.substring(j,i);
                for (String value : root) {
                    if (s.startsWith(value) && !found) {
                        ans+=value+" ";
                        found=true;
                    }
                }
                if(!found)
                    ans+=s+" ";
                j=i+1;
            }
            i++;
        }
        ans=ans.substring(0,ans.length()-1);
        return ans;
    }


    public int search(int[] nums, int target) {
        int l=0,h=nums.length;
        int mid;
        while (l<=h){
            mid=(l+h)/2;
            if(nums[mid]==target)
                return mid;
            else if (target<nums[mid]) {
                h=mid-1;
            }else {
                l=mid+1;
            }
        }
        return -1;
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num))
                return true;
            map.put(num, 1);
        }
        return false;
    }

    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=n*(n+1)/2;

        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();

        int n=nums.length;

        int i=0;
        while(i<n)
        {
            if(nums[nums[i]-1] != nums[i])
            {
                //place every number at its correct index
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            else
                i++;
        }
        i=0;
        while(i<n)
        {
            if(nums[i]-i !=1)
                ans.add(i+1);  //then simply find missing numbers
            i++;
        }


        return ans;
    }
}
