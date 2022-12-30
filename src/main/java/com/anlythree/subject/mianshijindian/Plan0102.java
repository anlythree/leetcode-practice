package com.anlythree.subject.mianshijindian;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * @DATE: 2022/12/29
 * @USER: anlythree
 */
public class Plan0102 {

    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap(s1.length());
        for (char c : s1.toCharArray()) {
            map.put(c,map.get(c) == null ? 1:map.get(c)+1);
        }
        for (char c : s2.toCharArray()) {
            if(map.get(c) == null || map.get(c) == 0){
                return false;
            }
            map.put(c,map.get(c)-1);
        }
        return true;
    }
}
