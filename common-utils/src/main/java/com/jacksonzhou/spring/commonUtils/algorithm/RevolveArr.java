package com.jacksonzhou.spring.commonUtils.algorithm;

/**
 * <p>功能描述：旋转数组</p>
 * <ul> eg. [3,7,4,2,5,9,8,6] 向右移动3个单位--> [9,8,6,3,7,4,2,5]
 * 解题思路：本质就是旋转数组，可以先将数组全部逆序，然后按照3两边再逆序
 * <li>@param </li>
 * <li>@return </li>
 * <li>@throws </li>
 * <li>@author My</li>
 * <li>@date 2020/9/17 11:09</li>
 * </ul>
 */
public class RevolveArr {

    public static void main(String[] args) {
        int[] arr = {3,7,4,2,5,9,8,6};
        arr = revolveArrWithIndex(arr, 0, arr.length-1);
        arr = revolveArrWithIndex(arr, 0, 2);
        arr = revolveArrWithIndex(arr, 3, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    private static int[] revolveArrWithIndex(int[] arr, int start, int end) {
        for (int i = start, j = end, count = 1; count <= (end + 1 - start) / 2; i++,j--,count++) {
            int swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
        }
        return arr;
    }
}
