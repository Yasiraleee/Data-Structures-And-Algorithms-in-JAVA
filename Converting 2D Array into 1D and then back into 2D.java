package com.company;

public class Main {
    public static void conquer(int arr[],int si,int mid,int ei){
        int sorter[]=new int[ei-si+1];
        int indx1=si;
        int indx2=mid+1;
        int x=0;
        while(indx1<=mid && indx2<=ei){
            if(arr[indx1]<=arr[indx2]){
                sorter[x++]=arr[indx1++];
            }else{
                sorter[x++]=arr[indx2++];
            }
        }
        while(indx1<=mid){
            sorter[x++]=arr[indx1++];
        }
        while(indx2<=ei){
            sorter[x++]=arr[indx2++];
        }
        for(int i=0,j=si;i<sorter.length;i++,j++){
            arr[j]=sorter[i];
        }
    }
    public static void divide(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }
    public static void main(String[] args) {
        int array[][] = { { 3, 12, 9 },
                { 5, 2, 89 },
                { 90, 45, 22 } };
        int k=0;
        int a[]=new int[array.length* array.length];

        //converting 2d into 1d

        for(int i=0;i<array.length;i++){
            for(int j=0;j< array.length;j++){
                k=j* array.length+i;
                a[k]=array[i][j];
            }
        }
        divide(a,0, a.length-1);
        for(int i=0;i< a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

        int s=0;
        //converting 1d back into 2d
        int a2[][]=new int[array.length][array.length];
        for(int i=0;i<array.length;i++){
            for(int j=0;j< array.length;j++){
                a2[j][i]=a[s];
                s++;
            }
        }
        for(int i=0;i<array.length;i++){
            for(int j=0;j< array.length;j++){
                System.out.print(a2[i][j]+" ");
            }
            System.out.println();
        }

    }
}
