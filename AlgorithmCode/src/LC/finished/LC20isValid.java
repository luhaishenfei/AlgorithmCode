package LC.finished;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC20isValid {

    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

     */

    //"([)]"
    // [([(())]){}]()
    /*
    执行用时：
1 ms
, 在所有 Java 提交中击败了
98.91%
的用户
内存消耗：
39.6 MB
, 在所有 Java 提交中击败了
24.92%
的用户
通过测试用例：
91 / 91

     */
    public boolean isValid(String s) {
        LinkedList list = new LinkedList<Character>();
//        for (char c : s.toCharArray()) {
            for (int i = 0; i < s.length(); i++) {
                char c=s.charAt(i);
                if (c == '{' || c == '[' || c == '(') {
                    list.add(c);
                } else {//}])
                    if (list.size()==0) return false;
                    if (isMacth((Character) list.getLast(),c)){
                        list.removeLast();
                    }else {
                        return false;
                    }
                }

            }

//        }
        return list.size()==0? true:false;
    }

    public boolean isMacth(int c1,int c2){
        if (c1=='{'&&c2=='}') return true;
        if (c1=='['&&c2==']') return true;
        if (c1=='('&&c2==')') return true;
        return false;
    }



/*
执行用时：
2 ms
, 在所有 Java 提交中击败了
53.85%
的用户
内存消耗：
39.8 MB
, 在所有 Java 提交中击败了
9.27%
的用户
通过测试用例：
91 / 91
 */
    public boolean isValidLC(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
