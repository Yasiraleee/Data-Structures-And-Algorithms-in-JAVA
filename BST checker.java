package com.company;
import javax.swing.tree.TreeNode;
import java.util.*;
public class Main {
    static class Tree{
        static class Node{
            int data;
            Node left;
            Node right;
            Node(int data){
                this.data=data;
                this.left=null;
                this.right=null;
            }
        }
        static class BinaryTree{
            static int indx1=-1;
            static Node ok(int node[]){
                indx1++;
                if(node[indx1]==-1){
                    return null;
                }
                Node newnode=new Node(node[indx1]);
                newnode.left=ok(node);
                newnode.right=ok(node);
                return newnode;
            }
        }
        static void inorder(Node node){
            if(node==null){
                return;
            }
            inorder(node.left);
            arr[i]=node.data;
            inorder(node.right);
        }
        static int arr[] = new int[7];
        static int i=0;
        static Boolean check()
        {
            for(int j=1 ;j < arr.length-1;j++)
            {
                if(arr[j-1] > arr[j]) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 7, -1, -1, 3, -1, 6, -1, -1};
        Tree.Node root= Tree.BinaryTree.ok(nodes);
        Tree.inorder(root);
        System.out.println(Tree.check());
    }
}