package org.element01.array;

public class Test06 {
    /**
     * 题目地址(59. 螺旋矩阵 II)
     *
     * 题目描述
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     *
     *
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：[[1]]
     *
     *
     *
     *
     * 提示：
     *
     * 1 <= n <= 20
     */

    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n-1;
        int top = 0;
        int down = n-1;
        int[][] ans = new int[n][n];

        int k = 1;
        while (k <= n*n){
            for (int i = left; i <= right; i++) {
               ans[top][i] = k++;
            }
            top ++;
            for (int i = top; i <= down; i++) {
                ans[i][right] = k++;
            }
            right --;

            for (int i =right; i >= left; i--) {
                ans[down][i] = k++;
            }
            down --;

            for (int i = down; i >= top ; i--) {
                ans[i][left] = k++;
            }
            left ++;
        }
        return ans;
    }

    /**
     * 复杂度分析
     *
     * 令 n 为数组长度。
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
}
