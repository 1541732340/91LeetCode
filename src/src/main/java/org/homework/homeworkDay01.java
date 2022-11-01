package org.homework;

public class homeworkDay01 {

    /**
     * 求 1 到 n 中所有整数 x 的 f(x) ，
     * 并以数组返回。其中 f(x) 指的是 x 的 2 的因子个数。
     * 比如 f(6) = 1 ，因为 6 = 2 * 3，只有一个因子 2 。
     * f(4) = 2 ，因为 4 = 2 * 2，有两个因子 2 。
     */

    public static int[] numFactor(int n){
        int[] result =  new int[n];

        for (int i = 1; i <=n; i++) {
            if ((i) % 2 != 0){
                result[i-1] = 0;
            }else {
                result[i-1] = result[(i-1)/2] + 1;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] re =numFactor(16);
        System.out.println(re);
    }
}
