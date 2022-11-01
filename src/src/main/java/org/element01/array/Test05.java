package org.element01.array;

public class Test05 {
    /**
     * 题目地址(41. 缺失的第一个正数)
     * https://leetcode.cn/problems/first-missing-positive/
     *
     * 题目描述
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     *
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,0]
     * 输出：3
     *
     *
     * 示例 2：
     *
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     *
     *
     * 示例 3：
     *
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     *
     *
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 5 * 105
     * -231 <= nums[i] <= 231 - 1
     *
     *
     */


    /**
     * 分析:
     *      1、输出的第一个缺失的正整数 只可能在 [1,len+1]的范围之内
     *      2、遍历数组,使其数据填到对应的位置上，将num[i]<1 和 num[i]>len的部分舍弃
     *
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != i + 1 && nums[nums[i] -1] != nums[i]){
                swap(nums,nums[i] -1,i);

            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1){
                return i+1;
            }
        }
        return len +1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 复杂度分析
     *
     * 令 n 为数组长度。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */


}
