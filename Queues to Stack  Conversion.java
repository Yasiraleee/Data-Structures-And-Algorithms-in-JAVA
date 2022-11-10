package com.company;
import java.util.Scanner;

class Sort
{
    static int count=0;
    class Node
    {

        int data;
        Node next;
    }
    Node front = null;
    Node rear = null;

    void Enqueue(int a)
    {   count++;
        Node newnode = new Node();
        newnode.data = a;

        if(front == null)
        {
            front=newnode;
            rear=newnode;
        }
        else
        {
            rear.next = newnode;
            rear = newnode;
        }
    }
    void dequeue()
    {
        if (front == null)
        {
            System.out.println("EMPTY!!!");
        } else
        {
            front = front.next;
        }
    }
    void display(){
        Node temp = front;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    void stack_using_queue(int data){
        Enqueue(data);
        int ok=count;
        for(int i=0;i<=ok;i++){
            Enqueue(top());
            dequeue();
        }
    }
    int top(){
        if(front==null){
            System.out.println("Empty!");
        }
        return front.data;
    }
}
public class Main
{
    public static void main(String[] args)
    {
        Sort s= new Sort();
        s.stack_using_queue(55);
        s.stack_using_queue(33);
        s.stack_using_queue(11);
        s.dequeue();
        s.display();

    }
}