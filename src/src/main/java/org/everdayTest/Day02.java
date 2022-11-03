package org.everdayTest;

public class Day02 {
    /**
     * 821. 字符的最短距离
     */

    /**
     * 题目描述:
     *      给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
     *
     *      返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
     *
     *      两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
     *
     */

    /**
     * 思路:
     *      正反遍历方式：
     *      1、正遍历记录从左侧到字符c的距离
     *      2、返遍历记录从右侧到字符c的距离
     *      取两者的最小值
     */

    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];
        int indexC1 = -n;
        for (int i = 0; i < n ; ++i) {//正向遍历
            if (s.charAt(i) == c){
                indexC1 = i;
            }
            res[i] = i - indexC1;
        }

        int indexC2 = 2*n;//反向遍历初始值使用2n的目地是防止下面取最小值时出现错误数据
        for (int i = n-1; i >=0 ; --i) {//反向遍历
            if (s.charAt(i) == c){
                indexC2 = i;
            }
            res[i] = Math.min(res[i],indexC2 - i);//取最小值
        }
        return res;
    }


    public static void main(String[] args) {
        int[] ints = shortestToChar("loveleetcode", 'e');
    }


}
