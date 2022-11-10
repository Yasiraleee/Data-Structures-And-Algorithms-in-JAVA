package com.company;
import java.util.Scanner;
class LinkedList{
    class Node{
        int data;
        Node next;
        Node front;
        Node rear;
        Node(int data){
            this.data=data;
            this.front=null;
            this.rear=null;
            this.next=null;
        }
    }
    Node front,rear=null;

    public void EnQueue(int data){
        Node newnode=new Node(data);
        if(front==null){
            front=newnode;
            rear=newnode;
            return;
        }
        rear.next=newnode;
        rear=newnode;
    }
    public void DeQueue(){
        if(front==null && rear==null ){
            System.out.println("Empty!");
        }
        front=front.next;
    }
    public void Display(){
        Node ptr=front;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
        System.out.println();
    }
}
class Array{
    static int sz=10;
    static int a[]=new int[sz];
    static int front=-1,rear=-1;

    public void EnQueue(int data){
        if(rear==sz-1){
            System.out.println("Overflow");
        }else {
            if (front == -1 && rear == -1) {
                front = 0;
                rear = 0;
                a[rear] = data;
            }else {
                rear++;
                a[rear] = data;
            }
        }
    }
    public void DeQueue(){
        if(front==-1 && rear==-1){
            System.out.println("UnderFlow");
        }else {
            front = front + 1;
        }
    }
    public void Display(){
        for(int i=front;i<=rear;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Array l1=new Array();
        l1.EnQueue(34);
        l1.EnQueue(66);
        l1.EnQueue(112);
        l1.EnQueue(84);
        l1.Display();
        l1.DeQueue();
        l1.Display();
    }
}