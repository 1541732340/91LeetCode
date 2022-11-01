package org.element01.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列
 */
public class Test08 {
    /**
     * 分析:
     *      有题目可知两个数组有以下特性:
     *          1、数组pushed中的元素互不相同;
     *          2、数组popped和pushed的长度相同;
     *          3、数组popped是数组pushed的一个排列;
     *
 *          总结以下结论:
     *          1、栈内不可能出现重复元素
     *          2、如果pushed和popped是有效的栈操作序列，则经过所有的入栈和出栈的操作之后,每个元素各入栈和出栈一次,栈为空
     *
 *          处理方法:
     *         遍历两个数组,模拟入栈和出栈操作,判断两个数组是否为有效的栈操作序列
     *         模拟入栈操作可以通过遍历数组pushed来实现
     *         由于只有栈顶的元素可以出栈，因此模拟出栈操作需要判断栈顶元素是否与popped的当前元素相同,如果相同则将栈顶元素出栈。
     *         由于元素互不相同，因此当栈顶元素与popped的当前元素相同时必须将栈顶元素出栈,否则出栈顺序一定不等于popped
 *         验证栈序列的模拟做法如下:
     *         1、遍历数组pushed,将pushed的每个元素依次入栈;
     *         2、每次将pushed的元素入栈之后,如果栈不为空且栈顶元素与popped的当前元素相同,则将栈顶元素出栈,同时遍历数组popped,知道栈为空或栈顶元素与popped的当前元素不同
     *         3、遍历数组pushed结束之后,每个元素都按照数组pushed的顺序入栈一次,如果栈为空,则每个元素都按照数组popped的顺序出栈,返回true;
     *         4、如果栈不为空，则元素不能按照数组popped的顺序出栈,返回false
     */


    public static boolean validateStackSequences(int[] pushed,int[] popped){
        Deque<Integer> stacks = new ArrayDeque<>();

        int len = pushed.length;
        for (int i = 0,j = 0; i < len; i++) {
            stacks.push(pushed[i]);//
            while (!stacks.isEmpty() && stacks.peek() == popped[j]){//false false
                stacks.pop();//
                j++;//1
            }
        }
        return stacks.isEmpty();

    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,1,2};
        boolean b = validateStackSequences(pushed, popped);
    }

}
