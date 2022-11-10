package com.company;

import java.util.ArrayList;

public class Main {
    static class Tree{
        static class Node{
            int data;
            Node left;
            Node right;
            Node(int data){
                this.data=data;
                this.left=left;
                this.right=right;
            }
        }
        static class BST{
            public static Node insert(Node root,int val){
                if(root==null){
                    root=new Node(val);
                    return root;
                }
                if(val< root.data){
                    root.left= insert(root.left,val);
                }else{
                    root.right= insert(root.right,val);
                }
                return root;
            }
        }
        static int arr[] = new int[7];
        static int i=0;
        static void Inorder(Node root){
            if(root==null){
                return;
            }
            Inorder(root.left);
            System.out.print(root.data+" ");
            Inorder(root.right);
        }
        static void check()
        {
            for(int j=1 ;j < arr.length-1;j++)
            {
                if(arr[j-1] > arr[j]) {
                    System.out.println("NOT BST");
                    break;
                }
            }
            System.out.println("BST!!");
        }
        static Boolean searcher(Node root,int target){
            if(root==null){
                return false;
            }else if(root.data>target){
                return searcher(root.left,target);
            }else if(root.data==target){
                return true;
            }else{
                return searcher(root.right,target);
            }
        }
        static Node Delete(Node root,int target){
            if(root.data>target){
                root.left=Delete(root.left,target);
            }else if(root.data<target){
                root.right=Delete(root.right,target);
            }else{
                if(root.right==null && root.left==null) {
                    return null;
                }
                if(root.right==null){
                    return root.left;
                }
                else if(root.left==null){
                    return root.right;
                }
                Node IS=ok(root.right);
                root.data=IS.data;
                root.right= Delete(root.right,IS.data);
            }
            return root;
        }
        public static Node ok(Node root){
            while(root.left!=null){
                root=root.left;
            }
            return root;
        }
        static void printinrange(Node root,int X,int Y){
            if(root==null){
                return;
            }
            if(root.data>=X && root.data<=Y){
                printinrange(root.left,X,Y);
                System.out.println(root.data+" ");
                printinrange(root.right,X,Y);
            }else if(root.data>=Y){
                printinrange(root.left,X,Y);
            }else{
                printinrange(root.right,X,Y);
            }
        }
        static void printpath(ArrayList<Integer>path){
            for(int i=0;i<path.size();i++){
                System.out.print(path.get(i)+" ");
            }
            System.out.println();
        }
        public static void leaf2path(Node root, ArrayList<Integer> path){
            if(root==null){
                return;
            }
            path.add(root.data);
            if(root.left==null && root.right==null){
                printpath(path);
            }else {
                leaf2path(root.left, path);
                leaf2path(root.right, path);
            }
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        int a[]={5,1,2,7,3,9};
        Tree.Node root=null;
        for(int i=0;i<a.length;i++){
            root = Tree.BST.insert(root,a[i]);
        }
        Tree.Inorder(root);
        System.out.println();
        System.out.println(Tree.searcher(root,5));
        System.out.println();
        Tree.check();
        Tree.Delete(root,2);
        Tree.Inorder(root);
        Tree.printinrange(root,6,10);
        System.out.println();
        Tree.leaf2path(root,new ArrayList<>());
    }
}
