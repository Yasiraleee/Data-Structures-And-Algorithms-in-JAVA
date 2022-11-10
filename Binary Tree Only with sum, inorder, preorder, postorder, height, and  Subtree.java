package com.company;

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
        public static class BinaryTree{
            static int x=-1;
            public static Node ok(int  a[]){
                x++;
                if(a[x]==-1){
                    return null;
                }
                Node newnode=new Node(a[x]);
                newnode.left=ok(a);
                newnode.right=ok(a);
                return newnode;
            }
            static int count=0;
            public static void Preorder(Node root){
                if(root==null){
                    return;
                }
                System.out.print(root.data+" ");
                Preorder(root.left);
                Preorder(root.right);
                count++;
            }
            public static void Inorder(Node root){
                if(root==null){
                    return;
                }
                Inorder(root.left);
                System.out.print(root.data+" ");
                Inorder(root.right);
            }
            public static int Height(Node root){
                if(root==null){
                    return 0;
                }
                int left=Height(root.left);
                int right=Height(root.right);
                if (left > right) {
                    return left+1;
                }else{
                    return right+1;
                }
            }
            public static int Sum(Node root){
                if(root==null){
                    return 0;
                }
                int left=Sum(root.left);
                int right=Sum(root.right);
                return left+right+root.data;
            }
        }
    }
    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Tree.Node data=Tree.BinaryTree.ok(node);
        System.out.println(data.data);
        Tree.BinaryTree.Preorder(data);
        System.out.println();
        Tree.BinaryTree.Inorder(data);
        System.out.println();
        System.out.println(Tree.BinaryTree.count);
        System.out.println(Tree.BinaryTree.Height(data));
        System.out.println(Tree.BinaryTree.Sum(data));
    }
}
