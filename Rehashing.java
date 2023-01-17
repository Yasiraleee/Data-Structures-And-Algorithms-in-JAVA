
public class Main {
    int[]a;
    int size;
    int enterie,limiter;
    Main(int size){
        this.size=size;
        this.limiter=size;
        a=new int[size];
        this.enterie=0;
        IsEmpty(a);
    }
    void IsEmpty(int a[]){
        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                a[i]=-1;
            }
        }
    }
    void insert(int data){
        int key=data%size;
        if(a[key]==-1){
            a[key]=data;
            enterie++;
        }else{
            for(int i=0;i<size;i++){
                int yes=(key+i)%size;
                if(a[yes]==-1){
                    a[yes]=data;
                    enterie++;
                    break;
                }
            }
        }
        float y=(float) enterie/limiter;
        if(y>=0.75){
            System.out.println("REHASHING NOW!");
            a=Rehashing();
        }
    }
    int[] Rehashing(){
        int a2[]=new int[a.length+2];
        for(int i=0;i<a.length;i++){
            a2[i]=a[i];
        }
        IsEmpty(a2);
        size=a2.length;
        return a2;
    }
    void print(){
        for(int i=0;i<size;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Main m=new Main(4);
        m.insert(76);
        m.insert(93);
        m.insert(40);
        m.insert(47);
        m.insert(10);
        m.insert(55);
        m.insert(22);
        m.insert(11);
        m.insert(56);
        m.insert(45);
        m.insert(5);
        m.print();
    }
}