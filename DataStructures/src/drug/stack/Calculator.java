package drug.stack;

/**
 * @author Drug
 * @create 2020-04-18 15:31
 */
public class Calculator {
    public static void main(String[] args) {
        //表达式
        String expression = "100*2-5";
        //数组栈
        ArrayStack2 numStack = new ArrayStack2(10);
        //符号栈
        ArrayStack2 operStack = new ArrayStack2(10);
        //数1
        int num1 = 0;
        //数2
        int num2 = 0;
        //符号
        int oper = 0;
        //取出来的字符
        char ch = ' ';
        //结果
        int res = 0;
        //表示读取的指针
        int index = 0;
        //用于拼接多位数
        String keepNum="";

        //计算
        while(true){
            ch = expression.substring(index,index+1).charAt(0);
            //判断是不是符号
            if(operStack.isOper(ch)){
                //ch是符号
                //当前符号栈是否为空
                if(operStack.isEmpty()){
                    //当前符号栈为空
                    operStack.push(ch);
                }else{
                    //当前符号栈不为空
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        //当前符号优先级小于等于符号栈优先级
                        //取出符号栈顶元素
                        oper = operStack.pop();
                        //取出数组栈顶两元素
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        //计算结果
                        res = operStack.calc(num1, num2, oper);
                        //结果入数组栈
                        numStack.push(res);
                        //当前符号入栈
                        operStack.push(ch);
                    }else{
                        //当前符号优先级大于符号栈优先级
                        operStack.push(ch);
                    }
                }
            }else{
                //ch不是符号
                //char因为是ASCII码表中数字,1对应49,比实际大了48,所以需要-48
                //numStack.push(ch - 48);//这种入栈只考虑了单位数,无法处理多位数
                //将ch拼接到keepNum,等待下一次判断
                keepNum += ch;
                if(index == expression.length()-1){
                    //此时到了表达式末尾
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    //此时还未到末尾
                    if(operStack.isOper(expression.substring(index+1, index+2).charAt(0))){
                        //下一个字符是操作符,直接入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //清空keepNum;
                        keepNum ="";
                    }
                }
            }
            index++;
            if(index == expression.length()){
                break;
            }
        }
        //此时表达式已全部入栈
        while(true){
            if(operStack.isEmpty()){
                //符号栈空,计算完毕
                break;
            }
            oper = operStack.pop();
            //取出数组栈顶两元素
            num1 = numStack.pop();
            num2 = numStack.pop();
            //计算结果
            res = operStack.calc(num1, num2, oper);
            //结果入数组栈
            numStack.push(res);
        }
        res = numStack.pop();
        System.out.println(expression+"的计算结果是"+res);
    }
}

class ArrayStack2 {
    //栈的最大值
    private int maxSize;
    //栈顶,默认为-1
    private int top = -1;
    private int[] stack;

    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 栈是否空
     * @return
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 栈是否满
     * @return
     */
    public boolean isFull(){
        return top==(maxSize-1);
    }

    /**
     * 压栈
     * @param i
     */
    public void push(int i){
        if(isFull()){
            System.out.println("栈满,无法增加");
            return;
        }
        top++;
        stack[top] = i;
    }

    /**
     * 弹栈
     * @return
     */
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空,无法弹栈");
        }
        int value = stack[top];
        top--;
        return  value;
    }

    /**
     * 遍历栈
     */
    public void show(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        for(int i=top;i>-1;i--){
            System.out.println("stack["+i+"]的值是"+stack[i]);
        }
    }

    /**
     * 显示栈顶元素
     * @return
     */
    public int peek(){
        return stack[top];
    }

    /**
     * 判断符号优先级
     * @param oper
     * @return
     */
    public int priority(int oper){
        if(oper=='*' || oper=='/'){
            return 1;
        }else if(oper=='+' || oper=='-'){
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 判断是否是符号
     */
    public boolean isOper(char ch){
        return ch=='+' ||ch=='-' ||ch=='/' ||ch=='*';
    }

    /**
     * 计算
     */
    public int calc(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case ('+'):
                res = num2+num1;
                break;
            case ('-'):
                res = num2-num1;
                break;
            case ('*'):
                res = num2*num1;
                break;
            case ('/'):
                res = num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}