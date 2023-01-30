package LC.finished;
/*
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

 

示例 1：

输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2：

输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 

提示：

1 <= prices.length <= 105
0 <= prices[i] <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC121MaxProfit {
    public static void main(String[] args) {
        LC121MaxProfit l = new LC121MaxProfit();
        int[] nums={7,1,5,3,6,4};
        System.out.println(l.maxProfit(nums));
    }

    /*
    执行用时：
2 ms
, 在所有 Java 提交中击败了
59.88%
的用户
内存消耗：
57.5 MB
, 在所有 Java 提交中击败了
51.02%
的用户
通过测试用例：
211 / 211
     */
    public  int maxProfit(int[] prices){
        int minBuy=prices[0];
        int maxProfit=0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit=Math.max(prices[i]-minBuy,maxProfit);
            minBuy=Math.min(prices[i],minBuy );
        }
        return maxProfit;
    }

    //暴力法，优化后,但实际运行时间还是too long
    public int maxProfitLC1(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }


    //超出时间限制，时间O太长了
    public int maxProfit1(int[] prices) {
        int[] maxProfit=new int[prices.length-1];
        int buyCost=0;
        int saleCost=0;
        for (int i = 0; i < prices.length-1; i++) {
            buyCost=prices[i];
            saleCost=buyCost;
            for (int j = i+1; j <prices.length ; j++) {
                if (prices[j]>saleCost){
                    saleCost=prices[j];
                }
            }
            if (saleCost>buyCost){
                maxProfit[i]=saleCost-buyCost;
            }else {
                maxProfit[i]=0;
            }
        }
        int maxAns=0;
        for (int i = 0; i < maxProfit.length; i++) {
            if (maxProfit[i]>maxAns){
                maxAns=maxProfit[i];
            }
        }
        return maxAns;
    }



}
