package com.jacksonzhou.spring.commonUtils.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
*<p>功能描述：说明：给定一个数组和一个目标值，找出相加之和等于目标值的数字，返回数字的下标</p>
*<ul> eg.[2,7,11,13] target: 9
 * 输出 ： [0,1]
*<li>@param </li>
*<li>@return </li>
*<li>@throws </li>
*<li>@author My</li>
*<li>@date 2020/8/23 16:25</li>
*</ul>
*/
public class findSumNumbers {

    public static int[] findSumNumbers(int[] arr, int target){
        Map<Integer, Integer> numMap = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            numMap.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int val = target - arr[i];
            if (numMap.get(val)!= null) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = numMap.get(val);
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,13};
        int[] result = findSumNumbers(arr, 18);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}
