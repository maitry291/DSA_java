package DSA_Heap;

public class demo {
    public static void main(String[] args) {
        /*Heap heap=new Heap();
        heap.add(1);
        heap.display();
        heap.add(10);
        heap.display();
        heap.add(15);
        heap.display();
        heap.add(5);
        heap.display();
        heap.add(20);
        heap.display();
        heap.add(18);
        heap.display();
        heap.add(19);
        heap.display();

        System.out.println(heap.remove());
        heap.display();*/

        HuffmanCoding coder=new HuffmanCoding("abbbccccda");
        System.out.println(coder.encoder);
        System.out.println(coder.encode("abbbccccda"));


    }
}
