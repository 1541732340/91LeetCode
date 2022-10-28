package org.element01.array;

import java.util.Arrays;

/**
 * 88.合并两个有序数组
 *
 * 题目描述:
 *  给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 *  说明:
 *
 *  初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *  你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  示例:
 *
 *  输入:
 *  nums1 = [1,2,3,0,0,0], m = 3
 *  nums2 = [2,5,6],       n = 3
 *
 *  输出: [1,2,2,3,5,6]
 */

public class Test03 {
    /**
     * 方法一:直接合并排序
     * 思路:
     *      * 将数组num2的数据放进数组num1内
     *      * 然后对整个数组进行排序
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i <n; i++) {//遍历时间复杂度O(n)
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);//排序时间复杂度(n log n)
    }
    /**
     * 复杂度分析：
     *      时间复杂度:由于排序的时间复杂度为O(n log n)
     *      空间复杂度:排序的操作需要的栈空间为O(log n)
     */

    /**
     * 方法二:双指针
     * 思路:
     *      * 将数组num2的数据放进数组num1内
     *      * 然后对整个数组进行排序
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m+n];
        int arr;
        while (p1 < m || p2 < n){
            if (p1 == m){
                arr = nums2[p2++];
            }else if (p2 == n){
                arr = nums1[p1++];
            }else if (nums1[p1] < nums2[p2]){
                arr = nums1[p1++];
            }else {
                arr = nums2[p2++];
            }
            sorted[p1+p2-1] = arr;
        }

        for (int i = 0; i < m+n; i++) {
            nums1[i] = sorted[i];
        }
    }
    /**
     * 复杂度分析：
     *      时间复杂度:O(n)
     *      空间复杂度:O(n)
     */



}
