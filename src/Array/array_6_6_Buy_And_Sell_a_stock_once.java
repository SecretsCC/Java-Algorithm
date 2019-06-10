package Array;

import java.util.ArrayList;
import java.util.List;

public class array_6_6_Buy_And_Sell_a_stock_once {

    public static double computMaxProfit(List<Double> prices ) {
        double minPrice = Double.MAX_VALUE;
        double maxProfit = 0;
        for(int i = 0; i < prices.size() - 1; ++i) {
            maxProfit = Math.max(maxProfit, prices.get(i) - minPrice);
            minPrice = Math.min(minPrice, prices.get(i));
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        List<Double> test = new ArrayList<>();
        test.add(310.0);
        test.add(315.0);
        test.add(275.0);
        test.add(295.0);
        test.add(260.0);
        test.add(270.0);
        test.add(290.0);
        test.add(230.0);
        test.add(255.0);
        test.add(250.0);
        System.out.println(computMaxProfit(test));
    }
}
