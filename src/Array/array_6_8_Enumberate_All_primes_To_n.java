package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class array_6_8_Enumberate_All_primes_To_n {

    public static List<Integer> generatePrimes(int n) {
        List<Integer> res = new ArrayList<>();
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrime.set(0,false);
        isPrime.set(1,false);

        for(int i = 2; i <= n; ++i) {
            if(isPrime.get(i)) {
                res.add(i);
                for (int j = i; j <= n; j += i) {
                    isPrime.set(j, false);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int num = 18;
        System.out.print(generatePrimes(num));
    }
}
