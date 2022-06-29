package LC;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LC954DoubleNumToArray {

    public static void main(String[] args) {
        LC954DoubleNumToArray l = new LC954DoubleNumToArray();
        int[] a = {2,1,2,6};
        System.out.println(l.canReorderDoubled(a));
    }

    public boolean canReorderDoubled(int[] arr) {
//            if (arr[2*i+1]!=2*arr[2*i]){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (Math.abs((int) o1) > Math.abs((int) o2)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        int count=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)==0){
                list.remove(i);
                i--;
                count++;
            }
        }
        if (count%2!=0){
            return false;
        }

        for (int i = 0; i < list.size()/2; i++) {
            int isExist=isExist(list.get(i),list);
            if (isExist>=0){
                list.set(i,0);
                list.set(isExist,0);
            }else {
                return false;
            }
        }
        return true;
    }
    public int isExist(int i,List<Integer> arr){
        for (int j = 0; j <arr.size() ; j++) {

            if (arr.get(j)==2*i){
                return j;
            }
        }
        return -1;


    }

    /*

     public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<Integer>();
        for (int x : cnt.keySet()) {
            vals.add(x);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/array-of-doubled-pairs/solution/er-bei-shu-dui-shu-zu-by-leetcode-soluti-2mqj/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    */


}
