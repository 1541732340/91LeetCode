package org.专题.滑动窗口;

import java.util.HashMap;

public class Test01 {
    /**
     * 3. 无重复字符的最长子串
     * 题目描述:给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */

    /**
     * 思路:
     *      用一个hashmap来建立字符和其出现位置之间的映射关系
     *      维护一个滑动窗口，窗口内的都是无重复的字符，去尽可能的扩大窗口的大小，窗口不断的向右滑动:
     *          1、如果当前遍历到的字符从未出现,那么直接扩大右边界
     *          2、如果当前遍历的字符出现过,则缩小窗口(左边指针右移),然后继续遍历
     *          3、重复 1 2 直到左边索引无法在移动
     *          4、维护一个结果 res 每次用出现过的窗口大小来更新结果res，最后返回res
     */

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i <s.length() ; i++) {
            if (hashMap.containsKey(s.charAt(i))){
                left = Math.max(left,hashMap.get(s.charAt(i))+1);
            }
            hashMap.put(s.charAt(i),i);
            right = Math.max(right,i - left +1);
        }
        return right;
    }

    /**
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     */

    public static void main(String[] args) {
        lengthOfLongestSubstring("ascasdwyqwu");
    }

}
