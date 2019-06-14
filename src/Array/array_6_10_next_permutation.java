package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1 Find K such that p[k] < p[k+1] and entries after index k appear in decreasing order
 * 2 Find the smallest p[l] such that p[l] > p[k](such an l must exist since p[k] < p[k+1])
 * 3 Swap p[l] and p[k](note that the sequence after position k remains in decreasing order)
 * 4 reverse the sequence after position k
 * [6,2,1,5,4,3,0] -> [6,2,3,5,4,1,0] - [6,2,3,0,1,4,5]
 *
 */
public class array_6_10_next_permutation {

    public static List<Integer> nextPermutation(List<Integer> perm){
        int k = perm.size() - 2;
        while( k>= 0 && perm.get(k) >= perm.get(k + 1)) {
            --k;
        }
        if(k == -1) {
            return Collections.emptyList();
        }

        //swap the smallest entry after index k that is greater than perm[k].
        //we exploit the fact that perm.subList(k+1, perm.size()) is decreasing so
        //if we search in reverse order, the first entry that is greater than perm[k]
        //is the smallest such entry
        for(int i = perm.size() - 1; i > k; --i) {
            if(perm.get(i) > perm.get(k)) {
                Collections.swap(perm,k,i);
                break;
            }
        }

        Collections.reverse(perm.subList(k + 1, perm.size()));
        return perm;

    }

    public static void main(String args[]) {
        List<Integer> test = new ArrayList<>();
        test.add(6);
        test.add(2);
        test.add(1);
        test.add(5);
        test.add(4);
        test.add(3);
        test.add(0);
        System.out.println(nextPermutation(test));
    }
}
