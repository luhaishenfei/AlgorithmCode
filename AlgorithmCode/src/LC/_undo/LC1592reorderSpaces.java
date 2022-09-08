package LC._undo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC1592reorderSpaces {
    public static void main(String[] args) {
        LC1592reorderSpaces l = new LC1592reorderSpaces();
        System.out.println(l.reorderSpaces("a"));
    }


    /*
	执行耗时:1 ms,击败了90.09% 的Java用户
	内存消耗:39.6 MB,击败了56.30% 的Java用户
     */
    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        int len = chars.length;
        int wordCount = 0;
        int emptyCount = 0;
        Queue<Character> words = new LinkedList<>();
        boolean isWord = false;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') {
                if (!isWord) {
                    wordCount++;
                    isWord = true;
                }
                words.add(chars[i]);
            } else {
                emptyCount++;
                if (isWord) {
                    isWord = false;
                    words.add(' ');
                }
            }
        }
        if (wordCount == 1) {
            for (int i = 0; i < len; i++) {
                if (words.size() > 0) {
                    chars[i] = words.poll();
                } else {
                    chars[i] = ' ';
                }
            }
        } else {
            int emptyNum = emptyCount / (wordCount - 1);
            int i = 0;
            while (words.size() != 0) {
                char c = words.poll();
                if (c != ' ') {
                    chars[i] = c;
                    i++;
                } else {
                    if (i + emptyNum < len) {
                        for (int j = 0; j < emptyNum; j++) {
                            chars[i] = ' ';
                            i++;
                        }
                    } else {
                        while (i < len) {
                            chars[i] = ' ';
                            i++;
                        }
                    }
                }
            }
            if (i != len) {
                while (i < len) {
                    chars[i] = ' ';
                    i++;
                }
            }
        }
        return new String(chars);
    }


    public String reorderSpaces1(String text) {
        char[] chars = text.toCharArray();
        int len = chars.length;
        int wordCount = 0;
        int emptyCount = 0;
        Queue<Character> words = new LinkedList<>();
        boolean isWord = false;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') {
                if (!isWord) {
                    wordCount++;
                    isWord = true;
                }
                words.add(chars[i]);
            } else {
                emptyCount++;
                if (isWord) {
                    isWord = false;
                    words.add(' ');
                }
            }
        }
        if (wordCount == 1) {
            for (int i = 0; i < len; i++) {
                if (words.size() > 0) {
                    chars[i] = words.poll();
                } else {
                    chars[i] = ' ';
                }
            }
        } else {
            int emptyNum = emptyCount / (wordCount - 1);
            int i = 0;
            while (words.size() != 0) {
                char c = words.poll();
                if (c != ' ') {
                    chars[i] = c;
                    i++;
                } else {
                    if (i + emptyNum < len) {
                        for (int j = 0; j < emptyNum; j++) {
                            chars[i] = ' ';
                            i++;
                        }
                    } else {
                        while (i < len) {
                            chars[i] = ' ';
                            i++;
                        }
                    }
                }
            }
            if (i != len) {
                while (i < len) {
                    chars[i] = ' ';
                    i++;
                }
            }
        }
        return new String(chars);
    }


    //    LCUser 双指针
    public String reorderSpacesLCUser(String text) {
        char[] s = text.toCharArray();//方便双指针处理
        int n = s.length, cntSpace = n, cntWord = 0;//字符串长度，总空格数目，单词数目
        for (int i = n - 1, j = n - 1, flag = 1; i >= 0; i--) {//双指针都从后向前遍历,i不断向前，j指向空格
            if (s[i] != ' ') {//s[i]遇到字母
                swap(s, i, j--);//字母和j指向的空格交换位置，j--空格前进
                cntWord += flag;//flag == 1代表之前s[i+1]是空格，说明s[i]这是单词的末位字母，单词个数+1
                flag = 0;//本单词的其他字母（和该字母相邻的字母）不再统计单词个数
                cntSpace--;//总空格数目初始化为n,每遇到一个字母就-1
            } else if (flag == 0) {//else代表当前s[i]是空格，flag == 0代表之前s[i+1]是字母，每个单词间只保留一个空格
                j--;//这是每个单词之间只保留一个的空格，用来间隔单词,只跳过字母前面的第一个空格，空格前面的空格是不跳过的
                flag = 1;// flag == 1表示之前s[i+1]是空格
            }
            // System.out.println("s:"+String.valueOf(s)+". flag="+flag+", s[i]="+"s["+i+"]="+s[i]+", s[j]="+"s["+j+"]="+s[j]+", cntSpace="+cntSpace+", cntWord="+cntWord);
        }
        for (int i = 0, j = 0, flag = 1, perSpace = cntSpace / Math.max(cntWord - 1, 1); i < n; ++i) {//双指针从前向后遍历字符串，i一直向后遍历，j指向空格，perSpace是平均每个单词之前的空格数量
            if (s[i] != ' ') {//i遇到字母
                swap(s, i, j++);//字母和空格交换
                flag = 0;//flag == 0标记当前遇到字母
            } else if (flag == 0) {// else说明s[i]是空格,flag == 0说明前一个是字母
                j += perSpace;//这是单词之前需要间隔的空格数量
                flag = 1;//flag == 1标记当前遇到空格
            }
            // System.out.println("s:"+String.valueOf(s)+". flag="+flag+", s[i]="+"s["+i+"]="+s[i]+", s[j]="+"s["+j+"]="+s[j]+", perSpace="+perSpace);
        }
        return String.valueOf(s);
    }

    public void swap(char[] s, int i, int j) {//辅助函数，交换
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
