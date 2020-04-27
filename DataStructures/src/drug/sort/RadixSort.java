package drug.sort;

import java.util.Arrays;

/**
 * @author Drug
 * @create 2020-04-27 16:28
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr={10,4,11,455,15,532,12};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基数排序
     * @param arr
     */
    public static void radixSort(int[] arr){
        //获取最大的数
        int maxNum = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] > maxNum){
                maxNum = arr[i];
            }
        }
        //获取最大数的位数
        int maxLength = (maxNum+"").length();
        //创建处理排序的通
        int[][] bucket = new int[10][arr.length];
        //创建记录各个桶里装的元素计数器,如bucketCount[0]表示bucket[0]里装的元素个数
        int[] bucketCount = new int[10];
        //需要处理maxLength次,第一次处理个位,第二次处理十位,第三次处理百位
        //count用来控制循环次数,n用来辅助取位数上的数字
        for(int count=0,n=1;count<maxLength;count++,n*=10){
            //用来遍历数组的每个数
            for(int i=0;i<arr.length;i++){
                //得到元素该轮位上的数
                int result = arr[i] / n % 10;
                //将该元素放入对应的桶中
                bucket[result][bucketCount[result]] = arr[i];
                //对应桶的计数器++
                bucketCount[result]++;
            }
            //到这里,原数组的元素已全部放入桶中,开始从桶中依次取出元素
            //index是原数组的下标
            int index = 0;
            //共有bucketCount.length个桶的元素需要取出
            for(int j=0;j<bucketCount.length;j++){
                //从桶中依次取出bucketCount[j]个元素
                for(int m=0;m<bucketCount[j];m++){
                    arr[index++] = bucket[j][m];
                }
                //取出元素后,将该桶计数器归零
                bucketCount[j] = 0;
            }
        }

    }
}
