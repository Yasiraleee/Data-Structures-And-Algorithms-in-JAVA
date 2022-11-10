package com.company;
class LinkedList{
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=next;
            this.prev=prev;
        }
    }
    Node head,tail=null;
    void addend(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
            return;
        }
        Node temp=head;
        tail.next=newnode;
        newnode.next=null;
        newnode.prev=tail;
        tail=newnode;
    }
    void addfirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
            return;
        }
        Node temp=head;
        temp.prev=newnode;
        head=newnode;
        newnode.next=temp;
        newnode.prev=null;
    }
    void addanywhere(int data,int pos){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
            return;
        }
        Node curr=head;
        Node temp=null;
        for(int i=0;i<pos-1;i++){
            temp=curr;
            curr=curr.next;
        }
        temp.next=newnode;
        newnode.next=curr;
        newnode.prev=temp;
    }
    void dfirst(){
        Node temp=head;
        Node ptr=null;
        ptr=temp.next;
        ptr.prev=null;
        head=ptr;
    }
    void dlast(){
        Node temp=head;
        Node ptr=tail.prev;
        ptr.next=null;
        tail=ptr;
    }
    void danywhere(int target){
        Node temp=head;
        Node ptr=null;
        while(temp.data!=target){
            ptr=temp;
            temp=temp.next;
        }
        ptr.next=temp.next;
        temp.prev=ptr;
    }
    int lenghtchecker(){
        Node curr=head;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        return count;
    }
    void sorting(){
        Node curr=head;
        Node ptr=null;
        int temp=0;
        for(curr=head;curr.next!=null;curr=curr.next){
            for(ptr=curr;ptr!=null;ptr=ptr.next){
                if(curr.data>ptr.data){
                    temp=curr.data;
                    curr.data= ptr.data;
                    ptr.data=temp;
                }
            }
        }
    }
    void display(){
        if(head==null){
            System.out.println("Empty");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"==>");
            temp=temp.next;
        }
        System.out.println("Null");
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList l1=new LinkedList();
        l1.addend(23);
        l1.addend(34);
        l1.addend(12);
        l1.addfirst(69);
        l1.addfirst(231);
        l1.addanywhere(27,2);
        l1.display();
        l1.dfirst();
        l1.dlast();
        l1.display();
        l1.danywhere(34);
        l1.display();
        System.out.println(l1.lenghtchecker());
        l1.sorting();
        l1.display();

    }
}



