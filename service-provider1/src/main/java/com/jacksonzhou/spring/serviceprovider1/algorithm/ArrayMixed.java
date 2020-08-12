package com.jacksonzhou.spring.serviceprovider1.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*<p>功能描述： 求两个数组的交集，不考虑顺序，元素在两个数组中出现次数一直就行</p>
*<ul>
*<li>@param </li>
*<li>@return </li>
*<li>@throws </li>
*<li>@author jackson</li>
*<li>@date 2020/7/24 15:21</li>
*</ul>
*/
public class ArrayMixed {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};

        Map<Integer, Integer> countMap1 = new HashMap<>();
        Map<Integer, Integer> countMap2 = new HashMap<>();
        for(int i : arr1){
            if (countMap1.containsKey(i)) {
                Integer count = countMap1.get(i);
                countMap1.put(i, ++count);
            }else{
                countMap1.put(i, 1);
            }
        }

        for(int i : arr2){
            if (countMap2.containsKey(i)) {
                Integer count = countMap2.get(i);
                countMap2.put(i, ++count);
            }else{
                countMap2.put(i, 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for(Integer integer : countMap1.keySet()){
            if (countMap2.containsKey(integer) && countMap2.get(integer).equals(countMap1.get(integer))) {
                result.add(integer);
            }
        }

        System.out.println("result: " + result.toString());
    }
}
