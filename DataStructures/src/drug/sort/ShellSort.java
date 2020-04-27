package drug.sort;

import java.util.Arrays;

/**
 * @author Drug
 * @create 2020-04-24 13:22
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 7, 8, 2, 0, 1, 4, 3, 6, 100, 50, 71, 60, 1, 3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Shell排序
    public static void shellSort(int[] arr) {
//        //交换法
//        //临时变量
//        int temp = 0;
//        //分组次数,比如10个数,第一次10/2=5组,第二次5/2=2组,第三次2/2=1组,排序后结束
//        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//            //
//            for (int i = gap; i < arr.length; i++) {
//                //遍历各组所有元素
//                for (int j = i - gap; j >= 0; j -= gap) {
//                    //如果前面的大于后面的数,就交换
//                    if(arr[j] > arr[j+gap]){
//                        temp = arr[j];
//                        arr[j] = arr[j+gap];
//                        arr[j+gap] = temp;
//                    }
//                }
//            }
//        }
        //优化交换法
        //希尔排序移位法
        //临时变量
        int temp = 0;
        int j = 0;
        //分组次数,比如10个数,第一次10/2=5组,第二次5/2=2组,第三次2/2=1组,排序后结束
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //遍历所有数
            for (int i = gap; i < arr.length; i++) {
                //如果arr[i]比同组前一个数小,则进入插入排序位移
                //用来遍历同组元素的下标
                j = i;
                //用来记录待插入元素
                temp = arr[j];
                //依次和同组前一个元素进行比较,如果前一个元素大于temp,则将前一个元素后移
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                //退出while时,arr[j]为合适位置
                arr[j] = temp;
            }
        }
    }
}
