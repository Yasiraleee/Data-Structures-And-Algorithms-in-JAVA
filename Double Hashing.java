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
        int ok=0;
        if(array[key]==-1){
            array[key]=data;
        }else{
            int pp=8-(data%8);
            while(ok==0){
                int yes=(key+i*pp)%size;
                if(array[yes]==-1){
                    array[yes]=data;
                    ok=1;
                    break;
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
            int pp=8-(data%8);
            for(int i=0;i<size;i++){
                int ok=(key+i*pp)%size;
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
            int pp=8-(data%8);
            for (int i = 0; i < size; i++) {
                int ok=(key+i*pp)%size;
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
        Hashing m=new Hashing(11);
        m.isEmpty();
        m.insert(20);
        m.insert(34);
        m.insert(45);
        m.insert(70);
        m.insert(56);
        m.print();
        m.search(56);
        m.delete(56);
        m.print();
    }
}
