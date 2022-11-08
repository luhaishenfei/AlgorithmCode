package ebook.grokkingAlgorithms;

public class _1LongestHuiWenString {
    public static void main(String[] args) {
       // getLongest("asdasdasd");
        long time = System.currentTimeMillis();
        System.out.println(longestPalindrome("asasdsadadqweqwadasdasdagagsdfsdasdgjfdgdfasdasdasgasdasdaeqsdafassdfaaaaasdasdasdfsdfaaaaasdaaaadfgasdfsdfsaasdfsdfaaaaaaasdfsdfasdfsdfaaaaaasdfsdfsdfsdfaaaaadfsdfsgfhgfddddfghjjjjhfgsgfffhfhfsdfgsdfsagaaasdaadasdaasdasasdasdsdaaaasdaaadasdasdaaaasdasasdadaasdasdasaaaaasdasdaaaasdasdaasdasdaaaasdasdaaasdfsdfgsadfsghklrtwrdfsaewrsddsgadfcxbaawdfawerwerdfgfdsa"));
        time -= System.currentTimeMillis();
        System.out.println(time);
    }

    public static int getLongest(String str){
        String reverStr = new StringBuilder(str).reverse().toString();



        return 0;
    }


    //
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        String res = s.substring(0, 1);

        // 枚举所有长度大于等于 2 的子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && valid(s, i, j)) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private static boolean valid(String s, int left, int right) {
        // 验证子串 s[left, right] 是否为回文串
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
