package com.jacksonzhou.spring.commonUtils.algorithm;

/**
 * <p>功能描述：股票收益问题，数组中是每天的股票价格，经过多次买入卖出怎样才能收货最大收益</p>
 * <ul> eg. [7,1,5,3,6,4,9]
 * 分析，最大收益肯定是最低价入最高价出的时候产生
 * <li>@param </li>
 * <li>@return </li>
 * <li>@throws </li>
 * <li>@author My</li>
 * <li>@date 2020/9/17 10:47</li>
 * </ul>
 */
public class StockProfile {

    public static int countStockProfile(int[] prices) {
        int finalProfile = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                finalProfile += prices[i] - prices[i - 1];
            }
        }
        return finalProfile;
    }


    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4,9};
        int val = countStockProfile(arr);
        System.out.println("val==="+val);
    }
}
