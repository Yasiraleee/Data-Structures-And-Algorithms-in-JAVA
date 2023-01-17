package com.company;

public class Main {
    int []array;
    int size;
    int key;
    public Main( int size){
        this.size=size;
        this.array=new int[size];
        this.key=0;
    }
    public void isEmpty(){
        for(int i=0;i<size;i++){
            array[i]=-1;
        }
    }
    public void insert(int value){
        key=value%size;
        if(array[key]==-1){
            array[key]=value;
            System.out.println(+value+" Inserted successfully");
        }
        else{
            System.out.println(+value+" unable to insert");
        }
    }
    public void search(int value){
        key=value%size;
        if(array[key]==value){
            System.out.println(+value+" Found");
        }
        else{
            System.out.println(+value+" Not found");
        }
    }
    public void delete(int value){
        key=value%size;
        if(array[key]==value){
            array[key]=-1;
        }
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {
        Main m=new Main(10);
        m.isEmpty();
        m.insert(42);
        m.insert(64);
        m.insert(78);
        m.insert(89);
        m.insert(52);
        System.out.println("After Insertion");
        m.print();
        System.out.println();
        m.search(64);
        m.search(52);
        m.delete(42);
        m.print();
    }
}