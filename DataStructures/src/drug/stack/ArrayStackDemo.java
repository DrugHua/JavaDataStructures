package drug.stack;

import java.util.Scanner;

/**
 * @author Drug
 * @create 2020-04-17 14:36
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("请输入你的选择");
            System.out.println("show:遍历栈");
            System.out.println("exit:退出程序");
            System.out.println("push:压栈");
            System.out.println("pop:弹栈");
            key = sc.next();
            switch (key){
                case "show":
                    arrayStack.show();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入数据:");
                    int value = sc.nextInt();
                    try {
                        arrayStack.push(value);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case "pop":
                    try {
                        int pop = arrayStack.pop();
                        System.out.println(pop);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("已退出程序");
    }


}

class ArrayStack {
    private int maxSize;  //栈的最大值
    private int top = -1; //栈顶,默认为-1
    private int[] stack;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈是否空
    public boolean isEmpty(){
        return top==-1;
    }
    //栈是否满
    public boolean isFull(){
        return top==(maxSize-1);
    }

    //压栈
    public void push(int i){
        if(isFull()){
            System.out.println("栈满,无法增加");
            return;
        }
        top++;
        stack[top] = i;
    }

    //弹栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空,无法弹栈");
        }
        int value = stack[top];
        top--;
        return  value;
    }

    //遍历栈
    public void show(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        for(int i=top;i>-1;i--){
            System.out.println("stack["+i+"]的值是"+stack[i]);
        }
    }
}
