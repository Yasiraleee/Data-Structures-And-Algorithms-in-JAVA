package com.company;
//add delete search
class Hashing{
    int value;
    int [] ok;
    int size;

    Hashing(int size){
        this.size=size;
        this.ok=new int[size];
        this.value=0;
    }
    void IsEmpty(){
        for(int i=0;i<size;i++){
            ok[i]=-1;
        }
    }
    void Insert(int value){
        int k=MidSquare(value);
        System.out.println(k);
        if(ok[k]==-1){
            ok[k]=value;
            System.out.println("check!");
        }else{
            System.out.println("Value Cannot be Inserted!");
        }
    }
    void Delete(int value){
        int y=MidSquare(value);
        if(ok[y]==value){
            ok[y]=-1;
        }else{
            System.out.println("Value Doesnt Exist!");
        }
    }
    void Search(int value){
        int y=MidSquare(value);
        if(ok[y]==value){
            System.out.println("Value Found!");
        }else{
            System.out.println("Value Doesnt Exist!");
        }
    }
    void Print(){
        for(int i=0;i<size;i++){
            System.out.print(ok[i]+" ");
        }
        System.out.println();
    }
    int  MidSquare(int value){
        int ok=0;
        int yes=0;
        while(value!=0){
            ok=value%100;
            value=value/100;
            yes=yes+ok;
        }
        if(yes>100){
            yes=yes%100;
        }
        return yes;
    }
}
public class Main {
    public static void main(String[] args) {
        Hashing h1=new Hashing(100);
        h1.IsEmpty();
        h1.Insert(6);
        h1.Insert(123);
        h1.Insert(10);
        h1.Insert(9452);
        h1.Insert(20);
        h1.Print();
        h1.Delete(20);
        h1.Search(123);
        h1.Delete(123);
        h1.Print();
    }
}