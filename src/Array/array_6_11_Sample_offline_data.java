package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class array_6_11_Sample_offline_data {
    public static void randomSampling(int k, List<Integer> A){
        Random gen = new Random();
        for(int i = 0; i < k; ++i) {
            //generate a random int in [i, A.size() - 1]
            Collections.swap(A,i,i+ gen.nextInt(A.size() - i));
        }
    }

    public static void main(String args[]) {
        List<Integer> test = new ArrayList<>();
        test.add(3);
        test.add(7);
        test.add(5);
        test.add(11);
        randomSampling(3,test);
        System.out.println(test);
    }
}
