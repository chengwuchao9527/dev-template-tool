package com.cheng.leetcode.stockissues;

import org.junit.jupiter.api.Test;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chengwuchao
 * @date 2022/7/6
 */
public class Question1 {


    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        // 暴力解法
        int maximumProfit1 = getMaximumProfit1(prices);
        System.out.println(maximumProfit1);
        // 一次遍历
        int maximumProfit2 = getMaximumProfit2(prices);
        System.out.println(maximumProfit2);


    }

    /**
     * 暴力解法
     *
     * @param prices
     * @return
     */
    private int getMaximumProfit1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                max = Math.max(temp, max);
            }
        }
        return max;
    }

    /**
     * 一次遍历
     *  假设最低点买入 次日价格如果比最低点小，则更新最新点，否则计算当天的收益，取最大收益
     * @param prices
     * @return
     */
    private int getMaximumProfit2(int[] prices) {
        // 买入的最低点
        int minPrices = Integer.MAX_VALUE;
        // 最大收益
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < minPrices){
                minPrices = prices[i];
            }else {
                max = prices[i] - minPrices;
            }
        }
        return max;
    }


}
