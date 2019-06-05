import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class multiply_two_arbitrarypricision_integer {
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0,Math.abs(num1.get(0)));
        num2.set(0,Math.abs(num2.get(0)));

        List<Integer> res = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
        for(int i = num1.size() - 1; i >= 0; --i) {
            for(int j = num2.size() - 1; j >= 0; --j) {
                res.set(i + j + 1, res.get(i + j + 1) + num1.get(i) * num2.get(j));
                res.set(i + j, res.get(i + j) + res.get(i + j + 1)/10 );
                res.set(i + j + 1, res.get(i + j + 1)%10);
            }
        }

        int first_no_zero = 0;
        while(res.get(first_no_zero) == 0 && first_no_zero < res.size()) {
            ++first_no_zero;
        }
        res = res.subList(first_no_zero,res.size());
        if(res.isEmpty()) {
            return Arrays.asList(0);
        }
        res.set(0,res.get(0) * sign);
        return res;
    }

    public static void main(String args[]) {
        List<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);
        List<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(2);
        test2.add(3);

        List<Integer> result = multiply(test1,test2);
        System.out.println(result);
    }

}
