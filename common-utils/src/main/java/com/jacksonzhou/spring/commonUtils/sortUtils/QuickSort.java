package com.jacksonzhou.spring.commonUtils.sortUtils;

/**
 * <p>功能描述：快速排序</p>
 * <ul> 快速排序采用的是首先定第一个数字，先从右向左判断有没有比基准数字小的，如果有则更换位置
 * 然后从左向右判断，判断有没有比数字大的，如果有则更换位置。旨与把第一个数字根据大小在数列中
 * 把位置定下来，然后针对数字左右两侧的子数列按照上述的规则进行递归。
 * <li>@param </li>
 * <li>@return </li>
 * <li>@throws </li>
 * <li>@author My</li>
 * <li>@date 2020/2/12 15:32</li>
 * </ul>
 */
public class QuickSort {

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

    /**
     * <p>功能描述：quickSort 快排的主方法</p>
     * <ul>
     * <li>@param [arr 对象数组, start快排开始的序号, end快排的结束序号]</li>
     * <li>@return void</li>
     * <li>@throws </li>
     * <li>@author My</li>
     * <li>@date 2020/2/12 15:39</li>
     * </ul>
     */
    public static int[] quickSort(int[] arr, int start, int end) {
        /*基准值，接下来的所有比较都是跟基准值比较*/
        int target = arr[start];
        int startIndex = start;
        int endIndex = end;
        while (startIndex < endIndex) {

            /*首先先从右向左判断是否存在元素比基准数字小，如果存在则换位置*/
            while (startIndex < endIndex) {
                if (arr[endIndex] < target) {
                    swap(arr, startIndex, endIndex);
                    /*注意：顺序是先有后左，所以需要break*/
                    break;
                } else {
                    endIndex--;
                }
            }

            /*然后从左到右判断是否存在元素比基准数字大，如果存在则换位置*/
            while (startIndex < endIndex) {
                if (arr[startIndex] > target) {
                    swap(arr, startIndex, endIndex);
                    /*注意：顺序是先右后左，所以需要break*/
                    break;
                } else {
                    startIndex++;
                }
            }
        }

        /*递归排序基准数字两端的子数列*/
        if ((startIndex - 1) > start) {
            quickSort(arr, start, (startIndex - 1));
        }
        if ((endIndex + 1) < end) {
            quickSort(arr, (endIndex + 1), end);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 6, 12, 13};
        int[] arrFinal = quickSort(arr, 0, 4);
        System.out.println(arrFinal);
    }

}
