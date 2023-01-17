package com.company;
class Hashing{
    int array[];
    int size;
    int key;
    Hashing(int size){
        this.size=size;
        this.array=new int[size];
        this.key=0;
    }

    void isEmpty(){
        for(int i=0;i<size;i++){
            array[i]=-1;
        }
    }
    void insert(int data){
        int key=data%size;
        int i=0;
        if(array[key]==-1){
            array[key]=data;
        }else{
            int ok=0;
            while(ok==0) {
                int twin = (key + i) % size;
                if(array[twin]==-1){
                    array[twin]=data;
                    ok=1;
                }
                i++;
            }
        }
    }
    void delete(int data){
        int key=data%size;
        if(array[key]==data){
            array[key]=-1;
        }else{
            for(int i=0;i<size;i++){
                int ok=(key+i)%size;
                if(array[ok]==data){
                    array[ok]=-1;
                    break;
                }
            }
        }
    }
    void search(int data) {
        int check=0;
        int key = data % size;
        if (array[key] == data) {
            System.out.println("Value Found!");
        } else {
            for (int i = 0; i < size; i++) {
                int ok=(key+i)%size;
                if(array[ok]==data){
                    System.out.println("Value Found!");
                    break;
                }
                check++;
            }
        }
        if(check==size){
            System.out.println("Value Not Found!");
        }
    }

    void print(){
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Hashing m=new Hashing(10);
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
        m.delete(52);
        m.print();
    }
}
