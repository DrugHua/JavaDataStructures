package drug.sort;

import java.util.Arrays;

/**
 * @author Drug
 * @create 2020-04-23 12:23
 */
public class InsertSort {
    public static void main(String[] args) {
        //测试
        int[] arr={10,51,-5,12,456,13,18,1,57,-262};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        int insertNum;
        int insertIndex;
        //插入排序将第一个数看做有序表,后面n-1个数看做无序表
        //所以循环n-1次即可排序
        for(int i=1;i<arr.length;i++){
            //保存待插入数
             insertNum = arr[i];
            //从待插入数前一个开始找
             insertIndex = i-1;
            //当当前插入序号大于等于0,并且当前插入序号的数大于待插入数时
            while(insertIndex>=0 && arr[insertIndex]<insertNum){
                //将当前插入序号数后移
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //退出循环时,insertIndex=-1或者当前插入序号数小于待插入数
            arr[insertIndex+1] = insertNum;
            System.out.println("第"+i+"轮的排序结果:"+ Arrays.toString(arr));
        }
    }
}
