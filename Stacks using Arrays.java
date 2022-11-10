package com.company;

import java.util.Scanner;

class Stack {
    static int sz=10;
    static int[] arr=new int[sz];
    static int top=-1;
    Scanner sc=new Scanner(System.in);
    public  void push(int data){
        if(top==sz-1){
            System.out.println("OverFlow!");
        }
        top++;
        arr[top]=data;
    }
    public  void pop(){
        if(top==-1){
            System.out.println("UnderFlow!");
        }
        top--;
    }
    public  void peek(){
        for(int i=top;i>=0;i--){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Stack s1=new Stack();
        for(int i=0;i<10;i++){
            s1.push(i);
        }
        s1.pop();
        s1.peek();

    }
}
