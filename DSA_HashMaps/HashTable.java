package DSA_HashMaps;

public class HashTable<K,V> {
    //hash table pair class
    private class HtPair{
        K key;
        V value;
        HtPair(K key,V value){
            this.key=key;
            this.value=value;
        }
       public String toString(){
            return "{"+this.key+"-"+this.value+"}";
       }
        public boolean equals(Object other){
            HtPair op= (HtPair) other;
            return this.key.equals(op.key);
        }
    }
    private GenericLL<HtPair>[] bucketArray;
    private int size;
}
