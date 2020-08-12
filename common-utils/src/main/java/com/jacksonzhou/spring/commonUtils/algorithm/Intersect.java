package com.jacksonzhou.spring.commonUtils.algorithm;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>功能描述：,每日一題：给定两个数组，编写一个函数来计算它们的交集。</p>
 * <ul>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]  输出: [2,2]
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]  输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * <li>@param </li>
 * <li>@return </li>
 * <li>@throws </li>
 * <li>@author My</li>
 * <li>@date 2020/8/12 21:18</li>
 * </ul>
 */
public class Intersect {

    public static List<Integer> intersectArr(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int val : arr1) {
            if (map.get(val) == null) {
                map.put(val, 1);
            } else {
                map.put(val, map.get(val) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int val : arr2) {
            if (null != map.get(val) && map.get(val) > 0) {
                map.put(val, map.get(val) - 1);
                result.add(val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{4,9,5};
        int[] num2 = new int[]{9,4,9,8,4};
        List<Integer> result = intersectArr(num1, num2);
        for (Object val :
                result) {
            System.out.println(val);
        }
    }
}
