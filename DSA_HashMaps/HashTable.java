package DSA_HashMaps;

public class HashTable<K, V> {

    //hash table pair class
    private class HtPair {
        K key;
        V value;

        HtPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "{" + this.key + "-" + this.value + "}";
        }

        @Override
        public boolean equals(Object o) {
            HtPair op = (HtPair) o;
            return op.key.equals(this.key);
        }
    }

    private static final int DEFAULT_CAPACITY = 10;
    private GenericLL<HtPair>[] bucketArray;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int size) {
        this.bucketArray = (GenericLL<HtPair>[]) new GenericLL[size];
        this.size = 0;
    }

    public void put(K key, V value) throws Exception {
        int bi = hashFunction(key);   //best index
        HtPair pair = new HtPair(key, value);
        GenericLL<HtPair> bucket = bucketArray[bi];
        if (bucket == null) {
            bucket=new GenericLL<>();
            bucket.addLast(pair);
            this.bucketArray[bi]=bucket;
            this.size++;
        } else {
            int findkey=bucket.findElement(pair);   //O(N)
            if(findkey==-1){
                bucket.addLast(pair);
                this.size++;
            }else{
                HtPair p=bucket.getAt(findkey);     //O(N)
                p.value=value;
            }
        }
        double loadFactor=this.size*1.0/ bucketArray.length;
        if(loadFactor>2){
            reHash();
        }
    }

    private void reHash() throws Exception {
        GenericLL<HtPair>[] oba=this.bucketArray;   //old bucket array
        this.bucketArray=(GenericLL<HtPair>[]) new GenericLL[2*oba.length];
        this.size=0;

        for(GenericLL<HtPair> ob:oba){
            while(ob!=null&&!ob.isEmpty()){
               HtPair pair=ob.removeFirst();
               put(pair.key, pair.value);
            }
        }

    }


    public V get(K key) throws Exception {
        int indx=hashFunction(key);
        GenericLL<HtPair> bucket=bucketArray[indx];
        HtPair ptf=new HtPair(key,null);
        if (bucket == null) {
            return null;
        } else {
            int findkey=bucket.findElement(ptf);   //O(N)
            if(findkey==-1){
                return null;
            }else{
                HtPair p=bucket.getAt(findkey);     //O(N)
                return p.value;
            }
        }
    }

    public void remove(K key) throws Exception {
        int indx=hashFunction(key);
        GenericLL<HtPair> bucket=bucketArray[indx];
        HtPair ptf=new HtPair(key,null);
        if (bucket == null) {
        } else {
            int findkey=bucket.findElement(ptf);   //O(N)
            if(findkey==-1){

            }else{
                bucket.removeAt(findkey);
                this.size--;
            }
        }
    }

    public void display(){
        for(GenericLL<HtPair> ll:bucketArray){
            if(ll!=null&&!ll.isEmpty()) {
                ll.display();
            }else
                System.out.println("NULL");
        }
        System.out.println("---------------------------------------------");
    }

    private int hashFunction(K key) {
        int hc = key.hashCode();    //hashcode will be unique for all diff keys and same for same key
        return Math.abs(hc) % bucketArray.length;
    }

}
