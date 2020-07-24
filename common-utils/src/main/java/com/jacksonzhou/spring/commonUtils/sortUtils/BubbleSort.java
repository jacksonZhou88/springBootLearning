package com.jacksonzhou.spring.commonUtils.sortUtils;

/**
 * <p>功能描述：冒泡排序每两个相邻的数字进行对比，如果值大的那个在值小的那个之前那么更换位置，
 * 然后第二个数字和第三个数字比较，同样上述操作，最后让最大的数字沉底，放在最后。
 * 接下来循环上述操作不包括最后一个数字</p>
 * <ul>
 * <li>@param </li>
 * <li>@return </li>
 * <li>@throws </li>
 * <li>@author My</li>
 * <li>@date 2020/2/12 18:36</li>
 * </ul>
 */
public class BubbleSort {

    /**
     * <p>功能描述：bubbleSort 冒泡排序算法</p>
     * <ul>
     * <li>@param [arr, start, end]</li>
     * <li>@return void</li>
     * <li>@throws </li>
     * <li>@author My</li>
     * <li>@date 2020/2/12 21:05</li>
     * </ul>
     */
    public static void bubbleSort(int[] arr, int start, int end) {
        if (arr.length <= 0) {
            return;
        }
        for (int i = start; i < end; i++) {
            for (int j = start; j < end - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

    }

    /**
     * <p>功能描述：swap 主要用户将数组中的数据进行更换位置</p>
     * <ul>
     * <li>@param [arr, index1, index2]</li>
     * <li>@return void</li>
     * <li>@throws </li>
     * <li>@author My</li>
     * <li>@date 2020/2/12 15:36</li>
     * </ul>
     */
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 6, 12, 13};
        long startTime = System.currentTimeMillis();
        bubbleSort(arr, 0, 4);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
