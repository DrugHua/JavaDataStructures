package drug.sparsearray;

public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        System.out.println("打印原始数组");
        for(int[] row : chessArr1){
            for(int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
        //统计非零数
        int notZero = 0;
        for(int[] row : chessArr1){
            for(int item : row){
                if(item !=0){
                    notZero++;
                }
            }
        }
        System.out.println("非零数");
        System.out.println(notZero);

        //创建稀疏数组
        int[][] sparseArray = new int[notZero+1][3];
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[0].length;
        sparseArray[0][2] = notZero;

        //稀疏数组赋值
        int count = 0;
        for(int m=0;m<chessArr1.length;m++){
            for(int n=0;n<chessArr1[0].length;n++){
                if(chessArr1[m][n]!=0){
                    count++;
                    sparseArray[count][0]=m;
                    sparseArray[count][1]=n;
                    sparseArray[count][2]=chessArr1[m][n];
                }
            }
        }

        //打印稀疏数组
        System.out.println("打印转换后的稀疏数组");
        for(int[] row : sparseArray){
            for(int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

        //稀疏数组恢复原始数组
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i=1; i<=sparseArray[0][2];i++){
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }


        System.out.println("打印恢复后的数组");
        for(int[] row : chessArr2){
            for(int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }
}
