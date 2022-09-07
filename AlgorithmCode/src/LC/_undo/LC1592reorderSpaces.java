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


    // 输入：" practice   makes   perfect"
    public String reorderSpaces(String text) {
        if (text == null) return null;
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
            if (i != len - 1) {
                while (i < len) {
                    chars[i] = ' ';
                    i++;
                }
            }
        }
        return new String(chars);
    }
}
