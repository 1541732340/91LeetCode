package org.element01.array;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test07 {
    /**
     * 题目地址(859. 亲密字符串)
     * https://leetcode.cn/problems/buddy-strings/
     *
     * 题目描述
     * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
     *
     * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
     *
     * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "ab", goal = "ba"
     * 输出：true
     * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
     *
     * 示例 2：
     *
     * 输入：s = "ab", goal = "ab"
     * 输出：false
     * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
     *
     * 示例 3：
     *
     * 输入：s = "aa", goal = "aa"
     * 输出：true
     * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
     *
     *
     *
     *
     * 提示：
     *
     * 1 <= s.length, goal.length <= 2 * 104
     * s 和 goal 由小写英文字母组成
     */

    public boolean buddyStrings(String s, String goal) {
        //1、长度不相等的情况 直接返回false
        if (s.length() != goal.length()){
            return false;
        }

        //2、当两个字符串相等时 判断字符串内是否含有重复元素
        if (s.equals(goal)){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            for (int i = 1; i < s.length(); i++) {
                if (chars[i-1] == chars[i]){
                    return true;
                }
            }
            return false;
        }

        //3、两个字符串不相等时,看交换之后是否能够相等
        List<Character> ls1 = new ArrayList<>();
        List<Character> ls2 = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)){
                ls1.add(s.charAt(i));
                ls2.add(goal.charAt(i));
            }
        }
        if (ls1.size() != 2){
            return false;
        }
        return ls1.get(0) == ls2.get(1) && ls1.get(1) == ls2.get(0);
    }
}
