package LC.undo;

import java.util.Arrays;

public class LC1668maxRepeating {

    public static void main(String[] args) {
        LC1668maxRepeating l = new LC1668maxRepeating();
        l.maxRepeating("abcbcd","bc");
    }

    public int maxRepeating(String sequence, String word) {
        char[] sequenceChars = sequence.toCharArray();
        char[] wordChars=word.toCharArray();
        int maxRepet=0;
        for (int i = 0; i <sequence.length() ; i++) {
            char c =sequenceChars[i];
            if (c==wordChars[0]){
                int j = 1;
                for (; j <word.length() ; j++) {
                    if (sequenceChars[i+j]!=wordChars[j]){
                        break;
                    }
                }
                if(j==word.length()) maxRepet++;
                i=i+j-1;
            }
        }
        return maxRepet;
    }


}
