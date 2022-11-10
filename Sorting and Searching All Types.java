package com.company;

import java.util.Scanner;

public class Main {
    public static void redix(int a[],int max){
        for(int pos=1;max/pos>0;pos=pos*10){
            BigFish(a,pos);
        }
    }
    public static void BigFish(int a[],int pos){
        int pp[]=new int[a.length+1];
        int check[]=new int[10];
        for(int i=0;i<a.length;i++){
            check[(a[i]/pos)%10]++;
        }
        for(int i=1;i<10;i++){
            check[i]=check[i]+check[i-1];
        }
        for(int i=a.length-1;i>=0;i--){
            pp[check[(a[i]/pos)%10]-1]=a[i];
            check[(a[i]/pos)%10]--;
        }
        for(int i=0;i<a.length;i++){
            a[i]=pp[i];
        }
    }
    public static int max(int a[]){
        int max=0;
        for(int i=0;i<a.length;i++){
            if(max<a[i]){
                max=a[i];
            }
        }
        return max;
    }
    public static void conq(int a[],int si,int mid,int ei){
        int sorter[]=new int[ei-si+1];
        int indx1=si;
        int indx2=mid+1;
        int x=0;
        while(indx1<=mid && indx2<=ei){
            if(a[indx1]<=a[indx2]){
                sorter[x++]=a[indx1++];
            }else{
                sorter[x++]=a[indx2++];
            }
        }
        while(indx1<=mid){
            sorter[x++]=a[indx1++];
        }
        while(indx2<=ei){
            sorter[x++]=a[indx2++];
        }
        for(int i=0,j=si;i<sorter.length;i++,j++){
            a[j]=sorter[i];
        }
    }
    public static void divide(int a[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        divide(a,si,mid);
        divide(a,mid+1,ei);
        conq(a,si,mid,ei);
    }
    public static   void quicksort(int a[],int lowerindex,int higherindex){
        if(lowerindex>=higherindex){
            return;
        }
        int pivot=a[higherindex];
        int lp=lowerindex;
        int rp=higherindex;
        while(lp<rp){
            while(a[lp]<=pivot && lp<rp){
                lp++;
            }
            while(a[rp]>=pivot && lp<rp){
                rp--;
            }
            sort(a,lp,rp);
        }
        sort(a,lp,higherindex);
        quicksort(a,lowerindex,lp-1);
        quicksort(a,lp+1,higherindex);
    }
    public static void sort(int a[],int i,int j){
        int temp=0;
        temp=a[i];
        a[i]=a[j];

        a[j]=temp;
    }
    public static int binarysearch(int a[],int target,Boolean flag){
        int l=0,r=a.length-1;
        int rez=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]==target){
                rez=mid;
                if(flag){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }else if(a[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return rez;
    }
    public static int interpolation(int a[],int target){
        int l=0,r=a.length-1;
        while(l<=r){
            int mid = l + (((r-l) / (a[r]-a[l]))*(target - a[l]));
            if(a[mid]==target){
                return mid;
            }else if(a[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
    public static void printing(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int a[]={23,12,543,5,43,6,768,72,45,23,6,7,56,54};
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Type Of Sort You Want To Do:\n1.Redix Sort:\n2.Quick Sort:\n3.Merge Sort:\n ");
        int y=sc.nextInt();
        if(y==1){
            int  t=max(a);
            redix(a,t);
        }else if(y==2){
            quicksort(a,0,a.length-1);
        }else{
            divide(a,0,a.length-1);
        }
        printing(a);
        System.out.println("Enter Any Number You Want To Search: ");
        int x=sc.nextInt();
        System.out.println("1>>Binary Search \n2>>Interpolation Search: \n");
        int ch=sc.nextInt();
        if(ch==1){
            int t=binarysearch(a,x,false);
            if(t==-1){
                System.out.println("Number Doesn't exist");
            }else{
                System.out.println("Number Is At Index: "+t);
            }
        }else{
            int t=interpolation(a,x);
            if(t==-1){
                System.out.println("Doesnt exist");
            }else{
                System.out.println("At Index: "+t);
            }
        }
    }
}

