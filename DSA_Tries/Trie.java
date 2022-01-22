package DSA_Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {

    private static class Node{
        char data;
        HashMap<Character,Node> children;
        boolean isTerminal;
        public Node(char data,boolean isTerminal){
            this.data=data;
            this.isTerminal=isTerminal;
            children=new HashMap<>();
        }
    }
    private int numWords;
    private final Node root;

    public Trie(){
        this.root=new Node('\0',false);
        this.numWords=0;
    }

    public int getNumWords(){ return this.numWords; }

    public void addWord(String word){
        this.addWord(this.root,word);
    }
    //O(length of word)
    private void addWord(Node parent,String word){
        if(word.length()==0){
            if(parent.isTerminal){
                //word already exists
            }else {
                parent.isTerminal=true;
                this.numWords++;
            }
            return;
        }
        char cc=word.charAt(0);
        String ros=word.substring(1);
        Node child = parent.children.get(cc);

        if(child==null){
            child=new Node(cc,false);
            parent.children.put(cc,child);
        }
        this.addWord(child,ros);
    }

    public void display(){
        display(this.root,"");
    }

    private void display(Node parent,String osf){
        if(parent.isTerminal){
            String toDisplay=osf.substring(1)+parent.data;
            System.out.println(toDisplay);
        }
        Set<Map.Entry<Character,Node>> entries=parent.children.entrySet();
        for(Map.Entry<Character,Node> entry:entries){
            this.display(entry.getValue(),osf+parent.data);
        }

    }


}
