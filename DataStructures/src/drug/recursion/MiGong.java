package drug.recursion;

import org.junit.jupiter.api.Test;

/**
 * @author Drug
 * @create 2020-04-19 13:23
 */
public class MiGong {
    @Test
    void test1() {
        //设置迷宫
        int[][] map = new int[8][7];
        //设置墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        for(int m=0;m<8;m++){
            for(int n=0;n<7;n++){
                System.out.print(map[m][n]+" ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        System.out.println("走过后的迷宫");
        for(int m=0;m<8;m++){
            for(int n=0;n<7;n++){
                System.out.print(map[m][n]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 终点假定为[6][5]位置
     * [i][j]位置为1是墙,2是通路,3是走过,但不通
     * @param map 传递迷宫
     * @param i 开始点行号
     * @param j 开始点列号
     * @return 如果找到通路,返回true,不然返回false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            //终点通路已有
            return true;
        }else{
            //开始判断当前点情况
            if(map[i][j] == 0){
                //当前点还没走过
                //将当前点设为2,表示走过
                map[i][j] = 2;
                if(setWay(map, i+1, j)){
                    //向下走
                    return true;
                }else if(setWay(map, i, j+1)){
                    //向右走
                    return true;
                }else if(setWay(map,i-1, j)){
                    //向上走
                    return true;
                }else if(setWay(map,i,j-1)){
                    //向左走
                    return true;
                }else{
                    //上下左右都试过无法达到,死路
                    map[i][j] = 3;
                    return false;
                }
            }else{
                //当前点已走过,1为墙,2为通路,3为死路,直接false即可
                return false;
            }
        }
    }
}
