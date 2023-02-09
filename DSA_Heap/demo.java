package DSA_Heap;

public class demo {
    public static void main(String[] args) {
        Heap heap=new Heap();
        heap.add(3);
        heap.add(2);
        heap.add(9);
        heap.add(10);
        heap.add(54);
        heap.add(21);
        //heap.add(2);
        heap.display();

        System.out.println(heap.remove());
        heap.display();

//        HuffmanCoding coder=new HuffmanCoding("abbbccccda");
//        System.out.println(coder.encoder);
//        System.out.println(coder.encode("abbbccccda"));


    }
}
