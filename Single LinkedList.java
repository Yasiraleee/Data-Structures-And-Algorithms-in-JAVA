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
    Node head=null;
    void addatlast(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newnode;
        newnode.next=null;
    }void addatfirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    void addatanywhere(int data,int pos){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
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
    void dend(){
        Node curr=head;
        Node ptr=null;
        while(curr.next!=null){
            ptr=curr;
            curr=curr.next;
        }
        ptr.next=null;
        curr=null;
    }
    void danywhere(int pos){
        Node curr=head;
        Node ptr=null;
        for(int i=0;i<pos-1;i++){
            ptr=curr;
            curr=curr.next;
        }
        ptr.next=curr.next;
    }
    void deletebynumber(int target){
        Node curr=head;
        Node ptr=null;
        while(curr.data!=target){
            ptr=curr;
            curr=curr.next;
        }
        ptr.next=curr.next;
    }
    void dfirst(){
        Node curr=head;
        head=curr.next;
        curr=null;
    }
    void swapper(int x,int y){
        if(x==y){
            return;
        }
        Node curr=head;
        Node ptr=null;
        while(curr!=null && curr.data!=x){
            ptr=curr;
            curr=curr.next;
        }
        Node curr2=head;
        Node ptr2=null;
        while(curr2!=null && curr2.data!=y){
            ptr2=curr2;
            curr2=curr2.next;
        }
        if(curr==null &&curr2==null){
            return;
        }
        if(ptr!=null){
            ptr.next=curr2;
        }else{
            curr2=head;
        }
        if(ptr2!=null){
            ptr2.next=curr;
        }else{
            curr=head;
        }
        Node temp=curr.next;
        curr.next=curr2.next;
        curr2.next=temp;
    }
    int lengthchecker(){
        int count=0;
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
            count++;
        }
        return count;
    }
    void sortingbubble(){
        Node curr=head;
        Node helper;
        int temp;
        for(curr=head;curr.next!=null;curr=curr.next){
            for(helper=curr.next;helper!=null;helper=helper.next){
                if(helper.data<curr.data){
                    temp=curr.data;
                    curr.data=helper.data;
                    helper.data=temp;
                }
            }
        }
    }
    void display(){
        if(head==null){
            System.out.println("Empty");
        }
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"===>");
            curr=curr.next;
        }
        System.out.println("Null");
    }
}
public class Main {
    public static void main(String[] args) {
        java.util.LinkedList<Integer> l1=new java.util.LinkedList<>();
        LinkedList ll=new LinkedList();
        ll.addatlast(56);
        ll.addatlast(1);
        ll.addatlast(99);
        ll.addatlast(2);
        ll.addatlast(3);
        ll.addatlast(55);
        ll.addatlast(4);
        ll.addatlast(5);
        ll.addatfirst(123);
        ll.addatanywhere(69,2);
        ll.display();
        ll.deletebynumber(55);
        ll.display();
        ll.sortingbubble();
        ll.display();
        System.out.println(ll.lengthchecker());
        ll.swapper(56,123);
        ll.display();
    }
}
