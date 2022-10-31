package org.element01.array;

import java.util.*;

/**
 * 380. 常数时间插入、删除和获取随机元素
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 *
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 *
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 *
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 *
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 *
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 *
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 *
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 */
public class Test04 {
    /**
     * 思路分析:
     *      1、数组支持随机访问，其按照索引查询的时间复杂度为O(1),按照值查询的时间复杂度为O(N),而插入和删除的时间复杂度为O(N)
     *      2、链表不支持随机访问，其查询的时间复杂度为O(N),但是对于插入和删除的复杂度为O(1),
     *      3、对于哈希表，正常情况下查询时间复杂度平均为O(N),插入和删除的时间复杂度为O(1)
     *
     *      根据题目要求,getRandom返回要随机并且时间复杂度为O(1)以内,则单独使用链表或哈希表不行
     *      而对于插入和删除也需要时间复杂度为O(1)，因此 单独使用数组也是不行的
     *
     *      对于插入：
     *          我们直接往append 并将其插入哈希表即可
     *          对于删除，我们需要做到O(1)，删除哈希表可以做到O(1),但是对于数组的删除，平均时间复杂度为O(N)
     *
     *          因此我们对于数据删除，我们的时间复杂度来源于:
     *          1、查找到要删除的元素
     *          2、重新排列被删除元素后面的元素
     *              对于1:我们采用哈希表来实现，key为要插入的数字 value为数组对应的索引,删除的时候我们根据key反查出索引即可快速找到(题目说明了不会存在重复元素)
     *              对于2:我们可以通过和数组最后一项进行交换的方式来实现,这样就避免了数据移动。同时数组其他项的索引仍然保持不变
     *
     */

    List<Integer> nums;//可以使用数组代替
    Map<Integer,Integer> maps;
    Random random;//随机数

    public void RandomizedSet(){
        nums = new ArrayList<Integer>();
        maps = new HashMap<Integer,Integer>();
        random = new Random();
    }

    public boolean insert(int val){
        if (maps.containsKey(val)){
            return false;
        }
        int index = nums.size();
        nums.add(val);
        maps.put(val,index);
        return true;
    }

    public boolean remove(int val){
        if (!maps.containsKey(val)){
            return false;
        }
        int index = maps.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index,last);
        maps.put(last,index);
        nums.remove(nums.size() -1);
        maps.remove(val);
        return true;
    }

    public int getRandom(){
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }

}
