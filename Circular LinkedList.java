package com.company;
class LinkedList{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=next;
        }
    }
    Node head,tail=null;
    void addatfirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
        tail.next=head;
    }
    void addatend(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
        newnode.next=head;
    }
    void addanywhere(int data,int pos){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
            return;
        }
        Node curr=head;
        Node ptr=null;
        for(int i=0;i<pos-1;i++){
            ptr=curr;
            curr=curr.next;
        }
        ptr.next=newnode;
        newnode.next=curr;
    }
    void dfirst(){
        Node curr=head;
        head=curr.next;
        tail.next=curr;
    }
    void dend(){
        Node curr=head;
        Node ptr=null;
        while(curr.next!=head){
            ptr=curr;
            curr=curr.next;
        }
        ptr.next=head;
        tail=ptr;curr=null;
    }
    void danywhere(int data){
        Node curr=head;
        Node ptr=null;
        while(curr.data!=data){
            ptr=curr;
            curr=curr.next;
        }
        ptr.next=curr.next;
    }
    void arranger(){
        Node curr=head;
        Node temp=null;
        int dtemp;
        for(curr=head;curr.next!=head;curr=curr.next){
            for(temp=curr.next;temp!=head;temp=temp.next){
                if(curr.data>temp.data){
                    dtemp=curr.data;
                    curr.data=temp.data;
                    temp.data=dtemp;
                }
            }
        }
    }
    int lenght(){
        Node temp=head;
        int count=0;
        do{
            count++;
            temp=temp.next;
        }while(temp!=head);
        return count;
    }
    void display(){
        if(head==null){
            System.out.println("Empty");
        }
        Node curr=head;
        do{
            System.out.print(curr.data+"===>");
            curr=curr.next;
        }while(curr!=head);
        System.out.println("Null");
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        LinkedList l2=new LinkedList();
        LinkedList l3=new LinkedList();LinkedList l4=new LinkedList();
        l3.addatend(232);
        l3.addatend(1224);
        l3.addatend(562);
        l3.addatend(221);
        l2.addatend(23);
        l2.addatend(124);
        l2.addatend(56);
        l2.addatend(21);
        ll.addatfirst(23);
        ll.addatfirst(55);
        ll.addatend(69);
        ll.addanywhere(4545,2);
        ll.dfirst();
        ll.dend();
        ll.addatend(12);
        ll.addatend(54);
        ll.danywhere(69);
        System.out.println(ll.lenght());
        ll.display();
        ll.arranger();
        ll.display();
    }
}


