package LC.undo;

import java.util.List;

/*
241. 为运算表达式设计优先级
给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。
你可以 按任意顺序 返回答案。
生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。



示例 1：

输入：expression = "2-1-1"
输出：[0,2]
解释：
((2-1)-1) = 0
(2-(1-1)) = 2
示例 2：

输入：expression = "2*3-4*5"
输出：[-34,-14,-10,-10,10]
解释：
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10


提示：

1 <= expression.length <= 20
expression 由数字和算符 '+'、'-' 和 '*' 组成。
输入表达式中的所有整数值在范围 [0, 99]
通过次数63,222提交次数83,561
 */
public class LC241diffWaysToCompute {

    //"2*3-4*5"
    public List<Integer> diffWaysToCompute(String expression) {
        //搞不定，就只能返回null了
        return null;
    }
}
