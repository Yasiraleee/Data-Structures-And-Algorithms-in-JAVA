package com.company;
import java.util.Arrays;
class Heap {
    private int[] heap;
    private int size;
    public Heap(int size) {
        this.heap = new int[size];
    }
    public void insert(int value) {
        if(size == heap.length){
            System.out.println("Heap overflow");
            return;
        }
        heap[size++] = value;
        int index = size - 1;
        int parentIndex = (index - 1)/2;
        while(index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index-1)/2;
        }
    }
    public int index(int x){
        int i;
        for (i = 0; i < heap.length; i++) {
            if(heap[i] == x)
                return i;
        }
        return -1;
    }
    public int leftChild(int index) {
        return heap[2*index+1];
    }
    public int rightChild(int index) {
        return heap[2*index+2];
    }
    private void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
    public int remove(){
        if(size == 0){
            System.out.println("Heap underflow");
            return -1;
        }
        int root = heap[0];
        heap[0] = heap[--size];
        int index = 0;
        if(!hasLeftChild(index) && !hasRightChild(index))
            return root;
        while(index <= size && (heap[index] < rightChild(index) || heap[index] < leftChild(index))){
            if(hasLeftChild(index) && hasRightChild(index)){
                int max = Math.max(leftChild(index),rightChild(index));
                swap(index, index(max));
                index = index(max);
            }
            else if(hasLeftChild(index)){
                swap(index,(2*index+1));
            }
            if(!hasLeftChild(index) && !hasRightChild(index))
                break;
        }
        return root;
    }

    private boolean hasRightChild(int index) {
        return 2*index+2 < size;
    }

    private boolean hasLeftChild(int index) {
        return 2*index+1 < size;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public boolean isFull(){
        return size >= heap.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap,0,size));
    }
}
