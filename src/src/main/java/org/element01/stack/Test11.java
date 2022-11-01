package org.element01.stack;

import java.util.Stack;

public class Test11 {
    /**
     * 394. 字符串解码
     *
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
     *
     */

    /**
     *思路:
     *    1、遍历字符串 从左到右解析字符串
     *    2、当前位置如果为数字位：
     *      2.1先解析出一个数字，然后解析到左括号,继续解析到右括号返回,构造数字x * 括号内字符
     *      2.2解析结束后 继续递归操作 解析右括号内容
 *        3、如果当前位置是字母位，那么我们直接解析当前这个字母，然后递归向下解析这个字母后面的内容。
     */
    public String decodeString(String s) {
        StringBuffer ans=new StringBuffer();
        Stack<Integer> multiStack=new Stack<>();
        Stack<StringBuffer> ansStack=new Stack<>();
        int multi = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                multi = multi *10 + c - '0';
            }else if (c == '['){
                ansStack.push(ans);
                multiStack.push(multi);
                ans = new StringBuffer();
                multi = 0;
            }else if (Character.isAlphabetic(c)){
                ans.append(c);
            }else {
                StringBuffer pop = ansStack.pop();
                Integer tmp = multiStack.pop();
                for (int i = 0; i < tmp; i++) {
                    pop.append(ans);
                }
                ans = pop;
            }
        }

        return  ans.toString();
    }

}
