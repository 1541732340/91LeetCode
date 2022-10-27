package org.element01.array;

/**
 * LeetCode:414.第三大数
 */

/**
 * 题目：
 *  给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 */

/**
 * 提示:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 * 进阶:
 * 你能设计一个时间复杂度 O(n) 的解决方案吗？
 */


public class Test01 {
    /**
     * 方法一:排序
     * 思路:
     *      * 将数组从大到小进行排序后，从头开始进行遍历，判断相邻元素是否相同，对元素个数进行统计；
     *      * 如果能找到三个以上不同的元素，则返回第三大的元素 否则返回最大的元素
     */
    public static int first(int[] nums) {
        if (nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0];
        }
        //升序排序
        Arrays.sort(nums);//排序需要的时间复杂度为O(n log n);
        //降序转换
        int left = 0;
        int right = nums.length-1;
        while (left < right){//排序转换时间复杂度为O(n/2)
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
        //遍历获取不同元素的个数
        int max = 1;
        for (int i = 1; i <nums.length ; i++) {//遍历时间复杂度O(n)
            if (nums[i] != nums[i-1] && ++max == 3){
                return nums[i];
            }
        }
        return nums[0];
    }

    /**
     * 复杂度分析：
     *      时间复杂度:由于排序的时间复杂度为O(n log n)
     *      空间复杂度:排序的操作需要的栈空间为O(log n)
     */


    /**
     * 方法二:有序集合
     * 思路:
     *      * 遍历数组，使用有序集合来维护数组中前三大的数
     *      * 每遍历一个数,就将其加入有序集合,若有序集合的大小超过3,则删除最小的元素
     *      * 遍历结束后,返回第三大的数
     */
    public static int second(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();//创建新的有序集合
        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() >3){//有序集合大小限制
                treeSet.remove(treeSet.first());
            }
        }
        return treeSet.size() == 3?treeSet.first():treeSet.last();
    }

    /**
     * 复杂度分析：
     *      时间复杂度:O(n),由于有序集合的大小至多为3，所以插入和删除的时间复杂度可以看作O(1)，综合来看，时间复杂度为O(n)
     *      空间复杂度:O(1)
     */

    /**
     * 方法二:有序集合
     * 思路:
     *      * 遍历数组，使用有序集合来维护数组中前三大的数
     *      * 每遍历一个数,就将其加入有序集合,若有序集合的大小超过3,则删除最小的元素
     *      * 遍历结束后,返回第三大的数
     */
    public static int third(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() >3){
                treeSet.remove(treeSet.first());
            }
        }
        return treeSet.size() == 3?treeSet.first():treeSet.last();
    }

    /**
     * 复杂度分析：
     *      时间复杂度:O(n),由于有序集合的大小至多为3，所以插入和删除的时间复杂度可以看作O(1)，综合来看，时间复杂度为O(n)
     *      空间复杂度:O(1)
     */




    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        int first = first(nums);
        System.out.print(first);
    }

}
