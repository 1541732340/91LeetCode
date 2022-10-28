package org.element01.array;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class Test02 {

    /**
     * 方法一:遍历查找
     * 思路:
     *      * 遍历数组
     *      * 1、从左到右遍历数组nums,如果存在0<=i<n-1,使得nums[i] != i,则缺失的数字满足要求
     *      * 2、如果对任意0<=i<n-1，都有nums[i] == i 则缺失的数字为n-1;
     */
    public int missingNumber(int[] nums) {
        int n = nums.length -1;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] != i){
                return i;
            }
        }
        return n-1;
    }
    /**
     * 复杂度分析：
     *      时间复杂度:O(n),
     *      空间复杂度:O(1)
     */

    /**
     * 方法二:数学方法
     * 思路:
     *      * 使用高斯求和公式
     *      * 1、先计算数组nums的和
     *      * 2、计算0到n-1的和
     *      * 3、两者的差值为缺失的数字
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length-1;
        int total = n *(n-1)/2;
        int arrNum = 0;
        for (int i = 0; i < n-1; i++) {
            arrNum += nums[i];
        }
        return total-arrNum;
    }
    /**
     * 复杂度分析：
     *      时间复杂度:O(n),
     *      空间复杂度:O(1)
     */

    /**
     * 方法三:二分法
     * 思路:
     *      * 使用二分法
     *      * 1、初始化边界
     *      * 2、每次计算中间点
     *      * 3、两者的差值为缺失的数字
     */
    public int missingNumber3(int[] nums) {
        if (nums[0] > 0) {
            // 比如 [1, 2, 3] 这种情况无法初始化 left 指针，因为压根不存在 nums[i] == i 的位置
            return 0;
        }
        if (nums[nums.length - 1] < nums.length) {
            // 比如 [0, 1, 2] 这种情况无法初始化 right 指针，因为压根不存在 nums[i] != i 的位置
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (right - left > 1) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == mid) {
                // 说明我们找到的 mid 这个位置的元素属于“左边的部分”，可以安全地把 left 指针移过来
                left = mid;
            } else if (nums[mid] != mid) {
                // 说明我们找到的这个 mid 这个位置的元素属于“右边的部分”，可以安全地把 right 指针移过来
                right = mid;
            }
        }
        // 比如 [1, 2, 4, 5] 这个数组，此时 left 会指向数字 2，right 会指向数字 4，显然 left + 1 就是我们要的答案
        return left + 1;
    }
    /**
     * 复杂度分析：
     *      时间复杂度:O(log n),
     *      空间复杂度:O(1)
     */





}
