package Array;

import java.util.ArrayList;
import java.util.List;

public class array_6_7_Buy_AND_Sell_Stock_Twice {

    public static double buyAndSellStockTwice(List<Integer> prices) {
        double maxTotalProfit = 0.0;
        List<Double> firstBuySellProfits = new ArrayList<>();
        double minPriceSoFar = Double.MAX_VALUE;

        //first buy
        for(int i = 0; i < prices.size(); ++i) {
            minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit,  prices.get(i) - minPriceSoFar);
            firstBuySellProfits.add(maxTotalProfit);
        }

        //second buy
        double maxPriceSoFar = Double.MIN_VALUE;
        for(int i = prices.size() - 1; i > 0; --i) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit, maxPriceSoFar - prices.get(i) + firstBuySellProfits.get(i - 1));
        }


        return maxTotalProfit;
    }


    public static void main(String args[]) {
        List<Integer> test = new ArrayList<>();
        test.add(12);
        test.add(11);
        test.add(13);
        test.add(9);
        test.add(12);
        test.add(8);
        test.add(14);
        test.add(13);
        test.add(15);
        System.out.println(buyAndSellStockTwice(test));
    }
}
