package com.anlythree.subject;

import org.junit.Test;

/**
 * 795. 区间子数组个数
 * 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
 * <p>
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * 示例 2：
 * <p>
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 *
 * @DATE: 2022/11/24
 * @USER: anlythree
 */
public class SectionListNum {

    /**
     * 思路：寻找所有可能的数组开始和结束点位，然后开始点位数量*结束点位数量 = 所有子数组的数量
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, last2 = -1, last1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                res += last1 - last2;
            }
        }
        return res;
    }

    @Test
    public void testNumSubarrayBoundedMax(){
        System.out.println(numSubarrayBoundedMax(new int[]{2,1,4,3},2,3));
    }


    /**
     * 思路：因为指定长度的数组中可以组合成的子数组数量是一定的，所以我们只需要计算出最外层被分割成了几个小数组，
     * 然后累加就可以的到一共有多少子数组
     * 这种思路有问题，因为题目中只限制了子数组中的最大值的值，所以最外层分割出来的子数组中 可能的组合可能不符合条件，比如示例 1中[1]这个子数组其实是不符合要求的
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Integer startIndex = null;
        Integer maxNum = null;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(startIndex == null && nums[i] <= right){
                // 开始
                startIndex = i;
                maxNum = nums[i];
                continue;
            }
            if(startIndex != null && nums[i] > maxNum){
                maxNum = nums[i];
            }
            if (startIndex != null && ( maxNum > right || maxNum < left)) {
                // 结束
                res += sum(i-startIndex);
                startIndex = null;
                maxNum = null;
            }
        }
        if(startIndex != null){
            res+=sum(nums.length-startIndex);
        }
        return res;
    }

    public int sum(int num){
        if(num < 2){
            return num;
        }
        return num * num - sum(num-1);
    }

    @Test
    public void testNumSubarrayBoundedMax1(){
        System.out.println(numSubarrayBoundedMax1(new int[]{2,1,4,3},2,3));
    }
}


