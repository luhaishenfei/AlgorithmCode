package LC;

public class LC1576_replaceQuestionMark {
    public static void main(String[] args) {
        System.out.println(modifyString("?b?p?o?d??gpapr???"));
    }
/*官方
执行结果：
通过
显示详情
添加备注

执行用时：
1 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
38.4 MB
, 在所有 Java 提交中击败了
62.20%
的用户
通过测试用例：
776 / 776
炫耀一下:
 */
public String modifyStringPlus(String s) {
    int n = s.length();
    char[] arr = s.toCharArray();
    for (int i = 0; i < n; ++i) {
        if (arr[i] == '?') {
            for (char ch = 'a'; ch <= 'c'; ++ch) {
                if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                    continue;
                }
                arr[i] = ch;
                break;
            }
        }
    }
    return new String(arr);
}


    /*
    执行结果：
通过
显示详情
添加备注

执行用时：
6 ms
, 在所有 Java 提交中击败了
5.12%
的用户
内存消耗：
38.7 MB
, 在所有 Java 提交中击败了
5.12%
的用户
通过测试用例：
776 / 776


    */

    private static String modifyString(String s) {
        char[] toCharArray = s.toCharArray();
        if (toCharArray[0]=='?'){
//            if ()toCharArray[0]='a';
        }

        for (int i = 1; i < toCharArray.length-1; i++) {
            if (toCharArray[i]=='?'){
                //have problem
                if (toCharArray[i-1]>'x'){
                    toCharArray[i]= (char) (toCharArray[i-1]-1);
                    if (toCharArray[i]==toCharArray[i+1]){
                        toCharArray[i]= (char) (toCharArray[i]-1);
                    }
                }else {
                    toCharArray[i] = (char) (toCharArray[i - 1] + 1);
                    if (toCharArray[i] == toCharArray[i + 1]) {
                        toCharArray[i] = (char) (toCharArray[i] + 1);
                    }
                }

            }
        }
        if (toCharArray[toCharArray.length-1]=='?'){
            //have problem
            if (toCharArray[toCharArray.length-2]!='a'){
                toCharArray[toCharArray.length-1]='a';
            }else {
                toCharArray[toCharArray.length-1]='b';
            }
        }

        s="";
        for (char c :
                toCharArray) {
            s+=c;
        }
        return s;
    }
    /*
    public static String modifyString(String s) {
        char exChar = ' ';
        char[] toCharArray = s.toCharArray();
        if (toCharArray.length ==1){
            if (toCharArray[0] =='?'){
                return "a";
            }
            else return s;
        }
        if (toCharArray.length ==2){
            if (toCharArray[0] ==toCharArray[1]){
                if (toCharArray[0] =='?'){
                    return "ab";
                }else if (toCharArray[0]=='z'){
                    return "az";
                }else {
                    return "ab";
                }
            }else if (toCharArray[0] =='?'){
                return (char(toCharArray[1]+1)+""+toCharArray[1])
            }else if (toCharArray[1]=='?'){

            }
        }
        for (int i = 0; i < toCharArray.length-1; i++) {

            if (toCharArray[i]!='?'&&toCharArray[i]!=exChar){
            //no problem
            }else{
                toCharArray[i]='a';
                if (exChar =='a'||toCharArray[i+1]=='a'){
                    toCharArray[i] = 'b';
                    if (exChar =='b'||toCharArray[i+1]=='b'){
                        toCharArray[i] = 'c';
                    }
                }
            }
            exChar=toCharArray[i];
        }
        if (toCharArray[toCharArray.length-1]==toCharArray[toCharArray.length-2]
                || toCharArray[toCharArray.length-1]=='?'){
            if (toCharArray[toCharArray.length-2]!='z'){
                toCharArray[toCharArray.length-1]= (char) (toCharArray[toCharArray.length-2]+1);
            }else {
                toCharArray[toCharArray.length-1]='a';
            }

        }
        s="";
        for (char c :
                toCharArray) {
            s+=c;
        }
        return s;
    }

     */
}
