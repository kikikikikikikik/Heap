/**
 * @ClassName Priority
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/9/22  14:12
 * @Veresion 1.0
 */
public class Priority {
    private static int[] array;
    private static int size;
    public Priority(int[] array,int size){
         array=new int[16];
         size=16;
    }
    public static int poll(){
        int old=array[0];
        array[0]=array[--size];
        shiftDownSmall(array,0,size);
        return old;
    }

    private static void shiftDownSmall(int[] array, int i, int size) {

        int left=i*2+1;
        while(left<size){
            int right=left+1;
            int small=right;
            if(right<size){
                if(array[left]<array[right]) {
                    small = left;
                }
            }
            if(array[small]<array[i]){
                swap(array,i,small);
                left=left*2+1;
            }
            else{
                break;
            }
        }
    }

    public static int peek(){
        return array[0];
    }
    public static void offer(int element){
        array[size++]=element;
        shiftUpSmall(array,size-1);
    }
    public static void shiftUpSmall(int[] array,int i){
        while(i!=0){
            if(array[i]<=array[(i-1)/2]){
                swap(array,i,(i-1)/2);
                i=(i-1)/2;

            }
            else{
                break;
            }
        }
    }

    public static void shiftDownBig(int[] array,int size,int index){
        int left=index*2+1;
        while (left < size) {
            int right = left + 1;
            int max = left;
            if (right < size) {
                if (array[left] < array[right]) {
                    max = right;
                }
            }
            if (array[index] < array[max]) {
                swap(array, index, max);
                index = max;
                left = index * 2 + 1;
            } else {
                break;
            }
        }

    }
    public static void CreateHeapBig(int[] a,int s){
        for(int i=s-2/2;i>=0;i--){
            shiftDownBig(a,i,s);
        }
    }
    private static void swap(int[] array, int i, int i1) {
     int t=array[i];
     array[i]=array[i1];
     array[i1]=t;
    }
    public static void heapSort(int[] array){
        CreateHeapBig(array,array.length);
        for(int i=0;i<array.length-1;i++){
            swap(array,0,array.length-i-1);
            shiftDownBig(array,0,array.length-1-i);
        }
    }
    public static void main(String[] args) {
        int[] array={10,40,20,60,70,30,5};
        shiftUpSmall(array,array.length-1);
        for(int i:array){
            System.out.println(i);
        }
    }
}
