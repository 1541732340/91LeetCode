package org.element01.stack;

public class Test10 {
    /**
     * 1381. 设计一个支持增量操作的栈
     *
     * 请你设计一个支持下述操作的栈。
     *
     * 实现自定义栈类 CustomStack ：
     *
     * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
     * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
     * int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
     * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
     *
     */

    /**
     * 思路:
     *      使用数组模拟栈,用一个变量 top 记录当前栈顶的位置
     *      1、对于push操作,首先判断当前元素的个数是否达到上限,如果没有达到上限,则把栈顶top后移一个位置 并添加元素
     *      2、对于pop操作,首先判断栈是否为空,非空则返回栈顶top对应位置的元素,栈顶top向前移一个位置 否则返回-1
     *      3、对于inc操作,对栈底的最多k个元素增加val
     */

    int[] stack;
    int top;

    public void CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top != stack.length -1){
            ++top;
            stack[top] = x;
        }
    }

    public int pop() {
        if (stack.length > 0 && top != -1){
            --top;
            return stack[top + 1];
        }
        return -1;
    }

    public void increment(int k, int val) {
        int min = Math.min(k, top + 1);
        for (int i = 0; i < min; i++) {
            stack[i] += val;
        }
    }

    /**
     * 复杂度分析
     *
     * 令 n 为数组长度。
     *
     * 时间复杂度：O(1)  inc的时间复杂度为O(k)
     * 空间复杂度：O(maxSize)
     */
}
