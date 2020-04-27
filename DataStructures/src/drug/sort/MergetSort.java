package drug.sort;

import java.util.Arrays;

/**
 * @author Drug
 * @create 2020-04-26 14:44
 */
public class MergetSort {
    public static void main(String[] args) {
        int[] arr= {10,1,-13,41,40,3};
        mergetSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 合并
     * @param arr 待排序数组
     * @param left 左边索引
     * @param mid  中间索引
     * @param right 右边索引
     */
    public static void merget(int[] arr,int left,int mid,int right){
        //分组左指针
        int l = left;
        //分组右指针
        int r = mid+1;
        //定义临时数组
        int[] temp = new int[arr.length];
        //临时数组指针
        int t = left;

        while(l<=mid && r<=right){
            //左边的值小于右边的值
            if(arr[l]<=arr[r]){
                temp[t] = arr[l];
                t++;
                l++;
            }else{
                //左边的值大于右边的值
                temp[t] = arr[r];
                t++;
                r++;
            }
        }
        //退出循环时,一边已经完成排序,将另外一边加入数组
        //这是左边没完成的情况
        while(l<=mid){
            temp[t] = arr[l];
            t++;
            l++;
        }
        //这是右边没完成的情况
        while(r<=right){
            temp[t] = arr[r];
            t++;
            r++;
        }
        //此时temp数组就是完成后的数组,将temp数组拷贝回原来的数组
        t = left;
        while(t<=right){
            arr[t] = temp[t];
            t++;
        }
    }

    /**
     * 归并排序
     * @param arr 待排序数组
     * @param start 起始索引
     * @param end 末尾索引
     */
    public static void mergetSort(int[] arr, int start,int end){
        //递归,将数组拆分成小元素
        if(start < end){
            int mid = (start+end)/2;
            //将左边拆分
            mergetSort(arr, start, mid);
            //将右边拆分
            mergetSort(arr, mid+1, end);
            //并排序
            merget(arr, start, mid, end);
        }
    }
}
