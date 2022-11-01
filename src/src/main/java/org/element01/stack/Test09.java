package org.element01.stack;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Stack;

public class Test09 {

    /**
     * 150. 逆波兰表达式求值
     *
     * 逆波兰表达式：
     *
     * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
     *
     * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
     * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
     * 逆波兰表达式主要有以下两个优点：
     *
     * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
     * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
     */

    /**
     * 思路:
     *      1、遍历列表，依次入栈,知道遇到算数运算符
     *      2、将栈顶的两个元素出栈运算，将结果压栈
     *      3、重复上述步骤 直到所有的token处理完毕
     */

    public static int evalRPN(String[] tokens){
        int[] numStack =  new int[tokens.length / 2 +1];
        int index = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    numStack[index - 2] += numStack[--index];
                    break;
                case "-":
                    numStack[index - 2] -= numStack[--index];
                    break;
                case "*":
                    numStack[index - 2] *= numStack[--index];
                    break;
                case "/":
                    numStack[index - 2] /= numStack[--index];
                    break;
                default:
                    numStack[index++] = Integer.parseInt(token);
                    break;
            }
        }
        return numStack[0];
    }

    public static void main(String[] args) {
        String[] req = new String[]{"1","2","+","3","*"};
        int i = evalRPN(req);
    }



}
