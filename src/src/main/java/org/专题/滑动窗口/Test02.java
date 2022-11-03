package org.专题.滑动窗口;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;

public class Test02 {

    /**
     * 76、最小覆盖子串
     *
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     * 注意：
     *
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     */

    /**
     * 思路:
     *      采用可变滑动窗口
     *      对于可变窗口，固定初始化左右指针L和R,分别对于窗口的左右顶点。  需要保证:
     *      1、L和R都初始化为0
     *      2、R指针移动一步
     *      3、判断窗口内的连续元素是否满足题目限定的条件
     *          3.1 如果满足，再判断是否需要更新最优解，如果需要则更新最优解。并尝试通过移动 l 指针缩小窗口大小。循环执行 4.1
     *          3.2 如果不满足，则继续。
     */

    public static String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int finishCount = 0;
        String res = "";
        int minLen = s.length();
        HashMap<Character, Integer>needHashMap = new HashMap<>();
        HashMap<Character, Integer>countHashMap= new HashMap<>();


//        if (t.length() > s.length()) {//字符串t的长度大于字符串s的长度
//            return res;
//        }

        for (int i = 0; i < t.length(); i++) {//记录t每个字符出现的次数
            char charAt = t.charAt(i);
            needHashMap.put(charAt,needHashMap.getOrDefault(charAt,0) +1);
        }

        while (right < s.length()){
            char cur = s.charAt(right);
            if (needHashMap.containsKey(cur)){
                countHashMap.put(cur,countHashMap.getOrDefault(cur,0)+1);
                // 两个Integer对象比较时，不能使用 == ，要使用equals，如果使用 == ，在[-128,127]范围内正常，范围外不正常
                if (countHashMap.get(cur).equals(needHashMap.get(cur))){
                    finishCount++;
                }
            }
            right++;

            while (finishCount == needHashMap.size()){
                char leftChar = s.charAt(left);
                if (countHashMap.containsKey(leftChar)
                        &&countHashMap.get(leftChar) >= needHashMap.get(leftChar)){
                    //记录满足条件的最小子串
                    String substring = s.substring(left, right);
                    if (substring.length() <= minLen){
                        res = substring;
                        minLen = substring.length();
                    }
                    countHashMap.put(leftChar,countHashMap.get(leftChar) -1);
                    if (countHashMap.get(leftChar) < needHashMap.get(leftChar)){
                        finishCount --;
                    }
                }
                left ++ ;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        minWindow("ab","a");
    }
}
