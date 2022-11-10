package com.company;
import java.util.Stack;
public class Main {
    static class Stack{
        class Node{
            int data;
            Node next;
            Node(int data){
                this.data=data;
                this.next=next;
            }
        }
        Node head=null;
        public void push(int data){
            Node newnode=new Node(data);
            if(head==null){
                head=newnode;
                return;
            };
            newnode.next=head;
            head=newnode;
        }
        public void pushatend(int data){
            if(head==null){
                push(data);
                return;
            }
            int x=pop();
            pushatend(data);
            push(x);
        }
        public void reverse(){
            if(head==null){
                return;
            }
            int x=pop();
            reverse();
            pushatend(x);
        }
        public int pop(){
            if(head==null){
                System.out.println("Empty");
            }
            int top=head.data;
            head=head.next;
            return top;
        }
        public int peek(){
            if(head==null){
                System.out.println("Empty");
            }
            return head.data;
        }
        public void pushatmiddle(int data,int val){
            if(head.data==val){
                push(data);
                return;
            }
            int x=pop();
            pushatmiddle(data,val);
            push(x);
        }
    }
    public static void main(String[] args) {
        Stack sc=new Stack();
        sc.push(1);
        sc.push(2);
        sc.push(32);
        sc.push(55);
        sc.pushatend(69);
        sc.reverse();
        sc.pushatmiddle(17395,2);
        while(sc!=null){
            System.out.println(sc.peek());
            sc.pop();
        }
    }
}
