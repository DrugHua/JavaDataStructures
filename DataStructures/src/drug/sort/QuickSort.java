package drug.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Drug
 * @create 2020-04-25 15:51
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            // 生成一个[0, 8000000) 数
            arr[i] = (int) (Math.random() * 8000000);
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr, 0, arr.length-1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }

    /**
     * 快速排序,分部排序,递归实现,基准数选左边第一个数
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr,int left,int right){
        //当左指针大于右指针时当前组排序完成,退出递归
        if(left > right){
            return;
        }
        //左指针
        int l = left;
        //右指针
        int r = right;
        //将左边的第一个数作为基准数
        int base = arr[left];
        //用于交换数字
        int temp;
        while(l < r){
            //找到右指针那里小于base的数
            //退出循环时,r等于l或者r已指向小于base的数
            while(arr[r] >= base && r>l){
                r--;
            }
            //找到左指针那里大于base的数
            //退出循环时,l等于r或者l已指向大于base的数
            while(arr[l] <= base && l<r){
                l++;
            }
            //如果l和r不相等,则说明数字需要交换
            if(l < r){
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        //退出循环时,l指针等于r指针,l指针左边的数全部小于base,l指针右边的数全部大于base
        //将base的值换到l指针的位置,准备下一次分两边递归
        arr[left] = arr[l];
        arr[l]  = base;
        //对当前l左边部分递归
        quickSort(arr,left,l-1);
        //对当前l右边递归
        quickSort(arr, l+1, right);
    }
}
