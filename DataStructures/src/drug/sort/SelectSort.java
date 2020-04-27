package drug.sort;

import java.util.Arrays;

/**
 * @author Drug
 * @create 2020-04-22 19:01
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {10,51,11,700,500,574};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        //设置最小索引
        int minIndex = 0;
        //设置最小值
        int min = 0;
        //共循环arr.length-1次(4个数,要动3次位置)
        for(int i=0;i<arr.length-1;i++){
            min = arr[i];
            minIndex = i;
            //从第几个数与min比较(
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            //如果minIndex不等于i,就交换
            //如果minIndex等于i,即刚好第i个就是最小值,无需交换
            if(minIndex != i){
                //将第i个值赋给当前最小索引位置
                arr[minIndex] = arr[i];
                //将最小值赋给第i个位置
                arr[i] = min;
            }
        }

    }
}
