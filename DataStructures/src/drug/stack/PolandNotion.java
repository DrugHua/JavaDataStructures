package drug.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Drug
 * @create 2020-04-18 17:39
 */
public class PolandNotion {
    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        //将运算字符串转换成中缀表达式的集合
        List list = toInfixExpression(expression);
        //遍历中缀表达式集合
        System.out.println(list);
        //将中缀表达式集合转换成后缀表达式集合
        list = parseInfixExpression(list);
        //遍历后缀表达式集合
        System.out.println(list);
        //运算
        int res = calc(list);
        //展示结果
        System.out.println(res);
    }

    /**
     * 将中缀表达式转换成后缀表达式
     *
     * @param infixExpression
     * @return
     */
    public static List<String> parseInfixExpression(List<String> infixExpression) {
        //符号栈
        Stack<String> stack = new Stack();
        //结果集
        List<String> list = new ArrayList<>();
        //遍历infixExpression,结果放入

        //遍历infixExpression
        for (String item : infixExpression) {
            if (item.matches("\\d+")) {
                //此时是数字
                list.add(item);
            } else if (stack.isEmpty()) {
                //空栈,直接入栈
                stack.push(item);
            } else if ("(".equals(item)) {
                //"("直接入栈
                stack.push(item);
            } else if (")".equals(item)) {
                //")"则从stack中依次弹出符号到list中,直到遇到"(",并抛弃
                while (!"(".equals(stack.peek())) {
                    list.add(stack.pop());
                }
                //丢弃"("
                stack.pop();
            } else {
                //此时item是四则运算福
                while (!stack.isEmpty() && Operation.getValue(stack.peek()) >= Operation.getValue(item)) {
                    //栈顶元素大于等于item优先级
                    list.add(stack.pop());
                }
                stack.push(item);
            }
        }
        //将stack中剩余符号pop到list中
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 将运算字符串转换成中缀表达式集合
     *
     * @param infixExpression
     * @return
     */
    public static List<String> toInfixExpression(String infixExpression) {
        int index = 0;
        char ch = ' ';
        String keepNum = "";
        List<String> list = new ArrayList<>();
        int length = infixExpression.length();

        while (index < length) {
            if (infixExpression.charAt(index) < 48 || infixExpression.charAt(index) > 57) {
                //此时是符号
                list.add("" + infixExpression.charAt(index));
                //index加一
                index++;
            } else {
                //此时是数字,先将keepNum置空
                keepNum = "";
                while (index < length) {
                    //取字符串第index个字符
                    ch = infixExpression.charAt(index);
                    //第index个字符仍是数字,继续拼接
                    if (ch >= 48 && ch <= 57) {
                        keepNum += ch;
                        index++;
                    } else {
                        //第index个字符不是数字,跳出
                        break;
                    }
                }
                //将拼接的keepNum加入数组
                list.add(keepNum);
            }
        }
        return list;
    }

    /**
     * 根据后缀表达式得到字符串集合
     *
     * @param strings
     * @return
     */
    public static List<String> getList(String[] strings) {
        List list = new ArrayList();
        for (String item : strings) {
            list.add(item);
        }
        return list;
    }

    /**
     * 后缀表达式运算
     *
     * @param list
     * @return
     */
    public static int calc(List<String> list) {
        Stack<String> strings = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        for (String item : list) {
            if (item.matches("\\d+")) {
                //item是数字,直接入栈
                strings.push(item);
            } else {
                //item是符号,弹出栈顶两数字运算,然后运算结果入栈
                num2 = Integer.parseInt(strings.pop());
                num1 = Integer.parseInt(strings.pop());
                //按item进行四则运算
                if ("+".equals(item)) {
                    res = num1 + num2;
                } else if ("-".equals(item)) {
                    res = num1 - num2;
                } else if ("*".equals(item)) {
                    res = num1 * num2;
                } else if ("/".equals(item)) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符号有误");
                }
                //结果入栈
                strings.push("" + res);
            }
        }
        //返回结果
        return res;
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    /**
     * 获得操作符的优先级
     *
     * @param value
     * @return
     */
    public static int getValue(String value) {
        int res = 0;
        switch (value) {
            case ("+"):
                res = ADD;
            case ("-"):
                res = SUB;
            case ("*"):
                res = MUL;
            case ("/"):
                res = DIV;
            default:
                break;
        }
        return res;
    }
}
