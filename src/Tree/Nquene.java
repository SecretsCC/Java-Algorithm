package Tree;

import java.util.ArrayList;
import java.util.List;

public class Nquene {
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;

    List<List<String>> res =  new ArrayList<>();

    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> tmp = new ArrayList<>();
        if(row.size() == n) {
            for(int i = 0; i < row.size(); ++i) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j  < row.size(); ++j) {
                    if(j == row.get(i)) {
                        sb.append('Q');
                        continue;
                    }
                    sb.append('.');

                }
                tmp.add(sb.toString());
            }
        }
        return tmp;
    }

    private void putQueen(int n, int index, List<Integer> row){
        if(index == n)  {
            res.add(generateBoard(n,row));
            return;
        }

        for(int i  =  0; i < n; ++i) {
            if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n,index + 1,row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
        return;
    }

    public List<List<String>> solveNQueens(int n) {
        col =  new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        List<Integer> row = new ArrayList<>();
        putQueen(n,0,row);
        return res;
    }
}
