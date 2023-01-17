package com.company;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class Graphs{
    int vertices;
    LinkedList<Integer> adj_list[];

    int edges;
    int[][] arr;

    Graphs(int num){
        this.vertices = num;
        this.edges=0;
        this.arr  = new int[num][num];
        adj_list = new LinkedList[num];
        for(int i=0;i<num;i++){
            adj_list[i] = new LinkedList<>();
        }
    }
    void add(int i,int j){
        adj_list[i].add(j);
        adj_list[j].add(i);
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<vertices;i++){
            s.append(i+1 + ": ");
            for(int j : adj_list[i]){
                s.append(j+1 + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    void addEdge(int i,int j){
        arr[i][j] = 1;
        arr[j][i] = 1;
        edges++;
    }
    void print(){
        System.out.println("\t1"  + "\t2"  + "\t3"  + "\t4"  +"\t5");
        for(int i=0;i<vertices;i++){
            System.out.print(i+1 +" : ");
            for(int j=0;j<vertices;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    void DFS(int v){
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while (!stack.isEmpty()){
            int visit = stack.pop();
            if(!visited[visit]){
                visited[visit] = true;
                System.out.print(visit + " ");
                for(int i : adj_list[visit]){
                    if(!visited[i]){
                        stack.push(i);
                    }
                }
            }
        }
    }
    void BFS(int v){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[v]  = true;
        queue.offer(v);
        while(!queue.isEmpty()){
            int visit = queue.poll();
            System.out.print(visit + " ");
            for(int i : adj_list[visit]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
public class Main {
    public static void main(String[] args){
        Graphs g = new Graphs(5);
        g.addEdge(0,3);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.add(0,3);
        g.add(1,3);
        g.add(1,4);
        g.add(2,4);
        g.add(3,4);
        g.print();
        System.out.println("\n"+g);
        System.out.println("\nDepthSearch");
        g.DFS(0);
        System.out.println("\nBreadthSearch");
        g.BFS(0);
    }
}