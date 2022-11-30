package LC.finished;
/*
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
//输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
//
// Related Topics 字符串 👍 366 👎 0
*/

import java.util.ArrayList;
import java.util.List;

//%20
public class LCOffer06replaceSpace {
    public static void main(String[] args) {
        LCOffer06replaceSpace l = new LCOffer06replaceSpace();
        String s = "Hello World ! ";
        System.out.println(l.replaceSpace(s));
    }

/*
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:39.2 MB,击败了74.89% 的Java用户

 */
    //very good
    public String replaceSpaceLC2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }


/*
> 2022/11/11 12:04:29
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:39.3 MB,击败了59.36% 的Java用户
 */
    public String replaceSpaceLC(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }

    /*
> 2022/11/11 12:01:29
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:39.6 MB,击败了20.54% 的Java用户
     */
    //perfect to me
    public String replaceSpace(String s) {
        List<Character> cList=new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c==' '){
                cList.add('%');
                cList.add('2');
                cList.add('0');
            }else {
                cList.add(c);
            }
        }
        char[] chars=new char[cList.size()];
        int idx=0;
        for (Character c :
                cList) {
            chars[idx]=c;
            idx++;
        }
        return String.valueOf(chars);
    }



    /*
 2022/11/11 11:56:36
解答成功:
执行耗时:1 ms,击败了14.55% 的Java用户
内存消耗:39.7 MB,击败了15.25% 的Java用户
 */
    //Just fine
    public String replaceSpace4(String s) {
        List<Character> cList=new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c==' '){
                cList.add('%');
                cList.add('2');
                cList.add('0');
            }else {
                cList.add(c);
            }
        }
        StringBuilder str=new StringBuilder();
        for (Character c :
                cList) {
            str.append(c);
        }
        return str.toString();
    }


    /*
    > 2022/11/11 11:33:49
解答成功:
	执行耗时:1 ms,击败了14.55% 的Java用户
	内存消耗:39.4 MB,击败了44.65% 的Java用户
     */
    //Just so so
    public String replaceSpace1(String s) {
        List<Integer> spacePos = new ArrayList();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                spacePos.add(i);
            }
        }
        char[] resChar = new char[s.length() + spacePos.size() * 2];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (spacePos.contains(i)) {
                resChar[idx] = '%';
                resChar[++idx] = '2';
                resChar[++idx] = '0';
            } else {
                resChar[idx] = chars[i];
            }
            idx++;
        }
        return String.valueOf(resChar);

    }


    /*
    解答成功:
	执行耗时:4 ms,击败了10.94% 的Java用户
	内存消耗:39.9 MB,击败了5.99% 的Java用户
     */
    //also trash
    public String replaceSpace3(String s) {
        String res = "";
        char[] chars = s.toCharArray();
        int lastSpace = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                res = res + String.valueOf(chars, lastSpace, i - lastSpace) + "%20";
                lastSpace = i + 1;
            }
        }
        res = res + String.valueOf(chars, lastSpace, chars.length - lastSpace);
        return res;
    }


    /*
    > 2022/11/11 11:36:34
解答成功:
	执行耗时:7 ms,击败了10.94% 的Java用户
	内存消耗:41.5 MB,击败了5.01% 的Java用户
     */
    //trash
    public String replaceSpace2(String s) {
        String res = "";

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                res = res + "%20";
            } else {
                res = res + c;
            }
        }
        return res;
    }


}
