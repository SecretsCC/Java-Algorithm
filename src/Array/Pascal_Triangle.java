package Array;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; ++i) {
            List<Integer> currRow = new ArrayList<>();
            for(int j = 0; j <= i; ++j) {
                currRow.add(0 < j && j < i ? res.get(i - 1).get(j - 1) + res.get(i - 1).get(j) : 1);
            }
            res.add(currRow);
        }
        return res;
    }

    public static void main(String args[]) {
        List<List<Integer>> test = generatePascalTriangle(5);
        System.out.println(test);
    }
}
