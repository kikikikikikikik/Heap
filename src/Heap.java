import java.util.Arrays;

/**
 * @ClassName Heap
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/9/22  11:11
 * @Veresion 1.0
 */
public class Heap {
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
    private static  void swap(int[] array,int m,int n){
        int tmp=array[m];
        array[m]=array[n];
        array[n]=tmp;
    }

    public static void main(String[] args) {
        int[] array={20,50,30,25,40,80,70,10,5,20,30,60,70,60,70,5};
        shiftDownBig(array,array.length,0);
        System.out.println(Arrays.toString(array));
    }
}
