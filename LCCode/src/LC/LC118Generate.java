package LC;

import java.util.ArrayList;
import java.util.List;

public class LC118Generate {

    public static void main(String[] args) {
        LC118Generate l = new LC118Generate();
        l.generate(7);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0||j==i) {
                    list.add(1);
                } else {
                    list.add(res.get(i-1).get(j-1) +res.get(i-1).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }

        public List<List<Integer>> generateLC(int numRows) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < numRows; ++i) {
                List<Integer> row = new ArrayList<Integer>();
                for (int j = 0; j <= i; ++j) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                    }
                }
                ret.add(row);
            }
            return ret;
        }
}
