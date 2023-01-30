package LC.finished.LC676MagicDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
执行用时：
33 ms
, 在所有 Java 提交中击败了
49.30%
的用户
内存消耗：
42.3 MB
, 在所有 Java 提交中击败了
52.76%
的用户
通过测试用例：
83 / 83
 */
class MagicDictionary {

    HashMap<Integer, List<String >> dic;


    public MagicDictionary() {
        this.dic=new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String str :
                dictionary) {
            int len=str.length();
            if (dic.get(len)==null){
                List<String> list=new ArrayList<>();
                list.add(str);
                dic.put(len,list);
            }else {
                dic.get(len).add(str);
            }
        }
    }

    public boolean search(String searchWord) {
        int len=searchWord.length();
        List<String> list=dic.get(len);
        if (list==null){
            return false;
        }else {
            for (String str :
                    list) {
                int differentCount=0;
                for (int i = 0; i < str.length(); i++) {
                    if(str.charAt(i)!=searchWord.charAt(i)){
                        differentCount++;
                    }
                }
                if (differentCount==1) return true;
            }
            return false;
        }
    }
}
