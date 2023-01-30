package LC.undo;

import java.util.Arrays;

public class LC1668maxRepeating {

    public static void main(String[] args) {
        LC1668maxRepeating l = new LC1668maxRepeating();
        System.out.println(l.maxRepeatingLC1("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
        //   "0aaaba 5aaaba 10aaba 14aaaba 19aaaba 24aaaba29 aaaba"
    }



    public int maxRepeatingLC1(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (n < m) {
            return 0;
        }

        int[] f = new int[n];
        for (int i = m - 1; i < n; ++i) {
            boolean valid = true;
            for (int j = 0; j < m; ++j) {
                if (sequence.charAt(i - m + j + 1) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                f[i] = (i == m - 1 ? 0 : f[i - m]) + 1;
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }






    public int maxRepeating(String sequence, String word) {
        char[] sequenceChars = sequence.toCharArray();
        char[] wordChars = word.toCharArray();
        int maxRepet = 0;
        int currRepet = 0;
        for (int i = 0; i < sequence.length(); i++) {
            int j = 0;
            while (i < sequenceChars.length && sequenceChars[i] == wordChars[j % word.length()]) {
                i++;
                j++;
                currRepet++;
            }
            if (j != 0) {
                maxRepet = currRepet > maxRepet ? currRepet : maxRepet;
                i = i - j % word.length()-1;
            }

        }
        return maxRepet / word.length();
    }

}
