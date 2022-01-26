package DSA_SegmentTree;

public class test {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8};
        SegmentTree st=new SegmentTree(a);
        st.display();
        st.updateElement(3,10);
        st.display();
        System.out.println(st.getSum(2,6));
        System.out.println(st.getSum(0,7));
    }
}
