package com.jacksonzhou.spring.commonUtils.sortUtils;

/**
 * <p>功能描述：归并排序</p>
 * <ul> 说明：归并排序是基于分治法，思路是将数量通过递归的方式下方到最小的子数列，然后将子数列进行排序之后
 * 往上把排好序的子数列按照大小合并成一个子序列，最后形成最终的顺序完整的序列
 * <li>@param </li>
 * <li>@return </li>
 * <li>@throws </li>
 * <li>@author My</li>
 * <li>@date 2020/2/13 11:16</li>
 * </ul>
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (end + start) / 2;
            /*将左数列进行排序*/
            mergeSort(arr, start, middle);
            /*将右数列进行排序*/
            mergeSort(arr, middle + 1, end);
            /*将左右数列进行合并*/
            merge(arr, start, middle, end);
        }
    }

    /*将左右数列进行合并*/
    private static void merge(int[] arr, int start, int middle, int end) {
        /*p1、p2表示左右数列的起始值指针*/
        int p1 = start, p2 = middle + 1, k = start;
        /*用于存储临时数据的数组*/
        int[] tmp = new int[arr.length];
        while (p1 <= middle && p2 <= end) {
            if (arr[p1] < arr[p2]) {
                tmp[k++] = arr[p1++];
            } else {
                tmp[k++] = arr[p2++];
            }
        }

        /*将剩余的数据合并过来*/
        while (p1 <= middle) tmp[k++] = arr[p1++];
        while (p2 <= end) tmp[k++] = arr[p2++];

        for (int i = start; i <= end; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 3, 9, 2, 12, 5, 17};
        mergeSort(arr, 0, 8);
        System.out.println(arr);
    }
}
