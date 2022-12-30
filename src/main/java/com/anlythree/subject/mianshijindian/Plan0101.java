package com.anlythree.subject.mianshijindian;

import org.junit.Test;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 简单
 * 256
 * 相关企业
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * s[i]仅包含小写字母
 * 如果你不使用额外的数据结构，会很加分。
 * @DATE: 2022/12/29
 * @USER: anlythree
 */
public class Plan0101 {

    public boolean isUnique(String astr) {
        int i = 0;
        for (char c : astr.toCharArray()) {
            int index = (int)c - (int)'a';
            if((i & 1 << index) == 0){
                i |= 1 << index;
            }else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1(){
        System.out.println(isUnique("aa"));
    }
}
