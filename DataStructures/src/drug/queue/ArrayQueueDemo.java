package drug.queue;

import java.util.Scanner;

/**
 * @author Drug
 * @create 2020-04-14 1:43
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("请输入操作:");
            System.out.println("p:展示数据");
            System.out.println("a:添加数据");
            System.out.println("g:获取数据");
            System.out.println("h:展示头部数据");
            System.out.println("e:退出程序");
            char choice = scanner.next().charAt(0);
            switch (choice){
                case 'p':
                    queue.peek();
                    break;
                case 'a':
                    System.out.println("请输入需要添加的数据");
                    int i = scanner.nextInt();
                    queue.add(i);
                    break;
                case 'g':
                    try {
                        int num = queue.get();
                        System.out.println("获取的数据是"+num);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 'h':
                    int num = 0;
                    try {
                        num = queue.headData();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    System.out.println("头部数据是:"+num);
                    break;
                case 'e':
                    loop = false;
                    break;
            }

        }
        System.out.println("已退出程序");
    }
}

class ArrayQueue{
    private int maxSize;//数组数组容量
    private int front;//指向头一个数据前一个位置
    private int rear;//指向尾部数据,包含尾部数据
    private int[] arr; //队列容器

    //构造队列
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        front = -1;
        rear = -1;
        arr = new int[arrMaxSize];
    }

    //判断是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //判断是否满了
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //增加数据
    public void add(int n){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取数据
    public int get(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    //遍历队列
    public void peek(){
        if(isEmpty()){
            System.out.println("队列为空,没有数据");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]:%d\n",i,arr[i]);
        }
    }

    //展示头数据
    public int headData(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }

}
