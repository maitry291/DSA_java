package DSA_Heap;

import java.util.ArrayList;

//this class is a min heap i.e. parent will have smaller value than child but the priority of parent is more.
//heap is known as priority queue.
//parent will have more priority than its children.
public class Heap {
    ArrayList<Integer> data=new ArrayList<>();

    public void add(int item){
        data.add(item);
        upHeapify(data.size()-1);
    }
    private void upHeapify(int ci){  //ci=child index
        int pi=(ci-1)/2;  //parent index

        //if child's value is smaller than its parent then we have to swap them
        //this swapping process till root node is called as upheapify.
        if(data.get(ci)<data.get(pi)){
            swap(ci,pi);
            upHeapify(pi);
        }
    }
    private void swap(int i,int j){
        int ith=data.get(i);
        int jth= data.get(j);

        data.set(i,jth);
        data.set(j,ith);
    }
    public void display(){
        System.out.println(data);
    }
    public int size(){
        return data.size();
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //deletion in the min heap will happen according to the priority
    public int remove(){
        //first we will swap first and last index element
        swap(0,data.size()-1);

        //we will remove the root element which is now at last in the array list
        //we swapped coz if we remove it from 0 index then we have to shift all elements to the left in list
        int rv=data.remove(data.size()-1);

        //now we have to set our heap from up to down
        downHeapify(0);

        return rv;
    }

    private void downHeapify(int pi) {
        int lci=2*pi+1;   //left child index
        int rci=2*pi+2;   //right child index

        //minimum index
        int mini=pi;

        if(lci< data.size()&&data.get(lci)<data.get(mini)){
            mini=lci;
        }
        if(rci< data.size()&&data.get(rci)<data.get(mini)){
            mini=rci;
        }

        if(mini!=pi) {
            swap(pi, mini);
            downHeapify(mini);
        }
    }

    //this function gives the highest priority element
    public int get(){
        return data.get(0);
    }

}
