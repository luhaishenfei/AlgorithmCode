package LC.undo;

/*
592. 分数加减运算
给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。

这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。



示例 1:

输入: expression = "-1/2+1/2"
输出: "0/1"
 示例 2:

输入: expression = "-1/2+1/2+1/3"
输出: "1/3"
示例 3:

输入: expression = "1/3-1/2"
输出: "-1/6"


提示:

输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
输入的分数个数范围是 [1,10]。
最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 */
public class LC592fractionAddition {
    public static void main(String[] args) {
        LC592fractionAddition l = new LC592fractionAddition();
//        System.out.println(l.gcd(2, 4));
        System.out.println(l.fractionAdd("-1/2", "1/2"));
    }

    /*
    1/2+1/2-1/2-1/2+1/2-1/2
    1/2 1/2-1/2-1/2 1/2-1/2

    expression = "-1/2+1/2+1/3"
     "1/3"
     */
    public String fractionAddition(String expression) {
        expression.replaceAll("-","+-");
        String[] fractions=expression.split("[+]");
        String sumF=null;
        String subF=null;
        for (int i = 0; i < fractions.length; i++) {
            if (fractions[i].charAt(0)=='-'){
                if (subF==null){
                    subF=fractions[i];
                }else {
                }
            }

            String[] e=fractions[0].split("[-]");
            String sum=e[0];
            if (e.length>1){
                for (int j = 1; j < e.length; j++) {
//                    sum=fractionSub()
                }
            }
        }

        return null;
    }

    int gcd(int m,int n){
        int t,r;
        if (m<n){
            t=m;
            m=n;
            n=t;
        }
        while ((m%n)!=0){
            r=m%n;
            m=n;
            n=r;
        }
        return n;

    }
    public String fractionAdd(String f1, String f2) {
        String[] f1s=f1.split("/");
        String[] f2s=f2.split("/");
        int f1Up= Integer.parseInt(f1s[0]);
        int f1Down= Integer.parseInt(f1s[1]);
        int f2Up= Integer.parseInt(f1s[0]);
        int f2Down= Integer.parseInt(f2s[1]);


        int resDown=f1Down*f2Down;
        int resUp=f1Up*f2Down+f2Up*f1Down;

        return  resUp+"/"+resDown;
    }

    public String fractionSub(String f1, String f2) {

        return null;
    }
}
