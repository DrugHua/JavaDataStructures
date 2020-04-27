package drug.recursion;

/**
 * @author Drug
 * @create 2020-04-19 14:43
 */
public class Queue8 {
    //设置最大皇后数 8
    int max = 8;
    //用于表示皇后放置情况,arr[m]=n表示第m+1个皇后摆放在第n+1列
    //arr[0]=[1]表示第1个皇后摆放在第2列
    int[] arr = new int[max];
    //用于统计解法次数
    static int count = 0;
    //用于统计judge判断次数
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        //开始摆放,并输出结果
        queue8.check(0);
        //统计解法次数
        System.out.println("共有解法数:"+count);
        //统计判断次数
        System.out.println("共判断了:"+judgeCount);
    }

    /**
     * 用来摆放
     * @param n 当前摆放第n+1个皇后(arr[n]表示第几个皇后,arr[0]表示第一个皇后)
     */
    private void check(int n){
        if(n==max){
            //此时摆放第9个皇后,即前8个皇后位置摆放完全正确
            //输出
            print();
            return;
        }
        //共摆放8个皇后,共8列
        for(int i=0;i<max;i++){
            //将第n个皇后摆放在第i列
            arr[n] = i;
            //如果第n个皇后摆放在第i列与前n-1个皇后不冲突
            if(judge(n)){
                //继续摆放第n+1个皇后
                check(n+1);
            }
            //如果第n个皇后摆放在第i列与前面皇后冲突
            //则i++,即第n个皇后摆放在第i++列
        }
    }
    /**
     * 判断当前第n个皇后是否满足前n-1个皇后的摆放位置要求
     * @param n
     * @return
     */
    private boolean judge(int n){
        for(int i=0;i<n;i++){
            judgeCount++;
            if(arr[i]==arr[n] || Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    /**
     *  打印,统计解法
     */
    private void print(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        count++;
    }
}

