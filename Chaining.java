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
    void addatfirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    void danywhere(int pos){
        Node curr=head;
        Node ptr=null;
        while(curr.data!=pos){
            ptr=curr;
            curr=curr.next;
        }
        ptr.next=curr.next;
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
    void Search(int num){
        int flag = 0;
        if(head == null)
            System.out.println("Null pointer exception");
        else{
            Node temp = head;
            while (temp != null) {
                if (temp.data == num) {
                    flag = 1;
                    System.out.println("Value "+num+" found!");
                    break;
                }
                temp = temp.next;
            }
            if(flag == 0)
                System.out.println("Value "+num+" not found");
        }
    }
}

class separateChaining {
    LinkedList[] obj;
    int size;

    public separateChaining(int size) {
        obj = new LinkedList[size];
        this.size = size;
    }

    protected void insert(int num){
        int index = num % size;
        System.out.println("NUmber: "+num+" Address: "+index);
        if(obj[index] == null)
            obj[index] = new LinkedList();
        obj[index].addatfirst(num);
    }

    protected void search(int num){
        int index = num % size;
        obj[index].Search(num);
    }
    protected void Deletion(int num)
    {
        int index = num%size;
        obj[index].danywhere(num);
    }

    protected void display(){
        System.out.println("---------------------------------------------------------");
        for (int i =0 ; i<size ; i++){
            if(obj[i]==null)
                continue;
            obj[i].display();
        }
        System.out.println("---------------------------------------------------------\n");
    }

}
public class Main {
    public static void main(String[] args) {
        separateChaining s = new separateChaining(50);
        for(int i : new int[]{100,200,300,440,990,50,8,6})
            s.insert(i);

        s.display();
        s.search(100);
        s.search(0);
        s.search(990);
        s.search(440);
        s.Deletion(200);
        s.display();
    }
}