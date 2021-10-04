package StacksAndQueues;
//every class by default extends object class in java.
//Object class have some methods like toString,hashcode,clone,equals which is given to every class object.
//t is a generic type.Generics mean parameterized types(Integer,String,...,User defined types.etc.)
//Generic types can be applied to methods,classes and interfaces.
//Using generics it is possible to create classes that work with different data types

import java.util.Comparator;

public class Generics {
    public static void main(String[] args) {
       car[] c=new car[3];
       c[0]=new car(250,"red");
       c[1]=new car(2000,"black");
       c[2]=new car(300,"grey");

       bubbleSortGeneric(c);
       for(car x:c){
           System.out.println(x.toString());
       }

       bubbleSortGeneric(c,new carColourComparator());
        for(car x:c){
            System.out.println(x.toString());
        }

    }
    //this method can be used for any class unlike below method that is used for only classes which implements
    //interface comparator.
    public static <t> void bubbleSortGeneric(t[] a, Comparator<t> comparator){
       //this method overloads below method.
        for(int counter=0;counter<a.length-1;counter++){
            for(int j=0;j<a.length-1;j++){
                if(comparator.compare(a[j],a[j+1])>0){
                    t temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    public static <t extends Comparable<t>> void bubbleSortGeneric(t[] a){
        //<t extends Comparable<t>> this means this method accepts objects of classes which implements
        //interface comparable.
        for(int counter=0;counter<a.length-1;counter++){
            for(int j=0;j<a.length-1;j++){
                if(a[j].compareTo(a[j+1])>0){
                  t temp=a[j];
                  a[j]=a[j+1];
                  a[j+1]=temp;
                }
            }
        }
    }
}
//interface mine<y>{}
class car implements Comparable<car>{
    int price;
    String colour;
    public car(int price,String colour){
        this.colour=colour;
        this.price=price;
    }
    @Override//from object class which is by default parent class of every class.
    public String toString(){
      return "["+this.colour+","+this.price+"]";
    }
    @Override
    public int compareTo(car o) {
        return this.price-o.price;
    }
}
class carPriceComparator implements Comparator<car>{
    @Override
    public int compare(car o1, car o2) {
        return o1.price-o2.price;
    }
}
class carColourComparator implements Comparator<car> {
    @Override
    public int compare(car o1, car o2) {
        return o1.colour.compareTo(o2.colour);
    }
}
