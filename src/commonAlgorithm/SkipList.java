package commonAlgorithm;

import java.util.LinkedList;
import java.util.List;

public class SkipList {
    List<Integer> originList;
    List<Integer> sub2List;
    List<Integer> sub4List;

    List<List> skipList;

    boolean isFind;

    SkipList() {
        skipList = new LinkedList<>();
        skipList.add(new LinkedList());
    }

    public void add(Integer element) {
        skipList.get(0).add(element);

    }

    public int search(int target) {
        isFind = false;
        int level = skipList.size() - 1;
        int l = 0;
        int r = skipList.get(0).size() - 1;
        while (l == r) {
            Integer element = sub4List.get(0);
            if (target > element) {
                return 0;
            }

        }
        return 0;
    }

    private int search(List<Integer> list, int target, int start, int end) {
        for (int i = start; i < end; i++) {
            int element=list.get(i);
            if (element == target) {
                isFind = true;
                return i;
            }else if (element < target) {
                return i;
            }
        }
        return end-1;


    }


}
