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
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        while (left <= right){
            mid = left + (right - left) >>1;
            if (mid + 1 < nums.length && nums[mid] == mid && nums[mid + 1] == mid +1){
                return mid+1;
            }else if (nums[mid] == mid){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        if (nums[0]==0){
            return nums.length;
        }else {
            return 0;
        }
    }
    /**
     * 复杂度分析：
     *      时间复杂度:O(n),
     *      空间复杂度:O(1)
     */





}
