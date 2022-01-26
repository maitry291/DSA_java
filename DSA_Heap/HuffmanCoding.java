package DSA_Heap;

//Huffman coding is a lossless data compression algorithm

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoding {

    private static class Node implements Comparable<Node>{
        char data;
        int freq;
        Node left;
        Node right;
        public Node(char data, int freq){
            this.data=data;
            this.freq=freq;
            this.left=null;
            this.right=null;
        }
        public Node(Node left,Node right){
            this.left=left;
            this.right=right;
        }

        @Override
        public int compareTo(Node o) {
            return o.freq-this.freq;
        }
    }

    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;

    public HuffmanCoding(String str){

        //create hashmap of frequency
        HashMap<Character,Integer> frequency=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(frequency.containsKey(c)){
                int of=frequency.get(c);
                frequency.put(c,++of);
            }else{
                frequency.put(c,1);
            }
        }

        //add all element of hashmap in heap/huffmanTree
        HeapGeneric<Node> huffmanTree=new HeapGeneric<>();
        Set<Map.Entry<Character,Integer>> entries=frequency.entrySet();
        for(Map.Entry<Character,Integer> entry:entries){
            Node nn=new Node(entry.getKey(),entry.getValue());
            huffmanTree.add(nn);
        }
        System.out.println(frequency);
        //combine nodes till one node left in min heap
        while(huffmanTree.size()!=1){
            Node fn=huffmanTree.remove();
            Node sn=huffmanTree.remove();

            Node nn=new Node(fn,sn);
            nn.freq=fn.freq+sn.freq;
            nn.data='\0';
            huffmanTree.add(nn);
        }

        //get last node from min heap
        Node finalNode=huffmanTree.remove();
        System.out.println(finalNode.freq);
        System.out.println(finalNode.right.freq);
        System.out.println(finalNode.left.freq);

        //to fill encoder decoder
        encoder=new HashMap<>();
        decoder=new HashMap<>();

        initEncoderDecoder(finalNode,"");
    }

    //to fill encoder decoder
    private void initEncoderDecoder(Node root,String osf){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            encoder.put(root.data,osf);
            decoder.put(osf,root.data);
        }
        initEncoderDecoder(root.left,osf+"0");
        initEncoderDecoder(root.right,osf+"1");
    }

    public String encode(String src){
        String ans="";

        for(int i=0;i<src.length();i++){
            String code=encoder.get(src.charAt(i));
            ans = ans + code;
        }

        return ans;
    }

    public String decode(String codedString){
        String ans="";
        String key="";

        for(int i=0;i<codedString.length();i++){
            key+=encoder.get(codedString.charAt(i));
            if(decoder.containsKey(key)) {
                ans = ans +decoder.containsKey(key);
                key=" ";
            }
        }

        return ans;
    }

}
