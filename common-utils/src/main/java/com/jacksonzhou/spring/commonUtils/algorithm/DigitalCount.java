package com.jacksonzhou.spring.commonUtils.algorithm;

/**
 * <p>功能描述：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。</p>
 * <ul> 输入：[1,2,3]
 * 输出：[1,2,4]
 * <li>@param </li>
 * <li>@return </li>
 * <li>@throws </li>
 * <li>@author My</li>
 * <li>@date 2020/8/23 15:19</li>
 * </ul>
 */
public class DigitalCount {


    public static int[] digitalCount(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if ((arr[i] + 1) % 10 == 0) {
                arr[i] = 0;
            }else{
                arr[i] = arr[i] + 1;
                return arr;
            }
        }
        int[] result = new int[arr.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,9,7};
        int[] result = digitalCount(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}
