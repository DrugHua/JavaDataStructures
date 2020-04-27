package drug.sort;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Drug
 * @create 2020-04-20 19:29
 */
public class BubbleSort {
    @Test
    void test(){
//        int[] arr = new int[]{3,9,-1,10,-2};
//        System.out.println("排序前结果是:"+Arrays.toString(arr));
//        BubbleSort(arr);
//        System.out.println("排序后结果是:"+Arrays.toString(arr));
        //测试80000个随机数排序时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdf.format(date);
        //当前时间是:2020-04-20 07:49:41
        System.out.println("当前时间是:"+format);
        int[] arr = new int[80000];
        for(int i=0;i<80000;i++){
            arr[i] = (int) (Math.random()*80000);
        }
        BubbleSort(arr);
        date = new Date();
        format = sdf.format(date);
        //排序完时间是:2020-04-20 07:49:52
        System.out.println("排序完时间是:"+format);
    }

    /**
     * 优化过的冒泡排序
     * @param arr
     */
    public void BubbleSort(int[] arr){
        //临时变量
        int temp = 0;
        //标记当前趟数有无数字交换,若没有数字交换,数组已然有序
        //默认为false
        boolean flag = false;
        //循环趟数
        for(int i=0;i<arr.length-1;i++){
            //比较个数
            for(int j=0;j<arr.length-1-i;j++){
                //如果前面比后面大,交换
                if(arr[j] > arr[j+1]){
                    //当前轮次数组有交换过数据
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
//            System.out.println("这是第"+(i+1)+"躺排序后的结果:"+Arrays.toString(arr));
            if(!flag){
                //本轮次没有数字进行交换,已经有序
                break;
            }else{
                //本路有数字进行过交换,置为false,下轮继续判断
                flag = false;
            }
        }
    }

}
