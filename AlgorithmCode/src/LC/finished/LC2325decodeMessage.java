package LC.finished;

public class LC2325decodeMessage {
    public static void main(String[] args) {
        LC2325decodeMessage l = new LC2325decodeMessage();
        int[] password = l.getPasswordMap("eljuxhpwnyrdgtqkviszcfmabo");
        System.out.println(password);
        String s = l.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeiusycgk vcnjrdb");
        System.out.println(s);
    }

    //输入：key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius
    //ycgk vcnjrdb"
    //输出："the five boxing wizards jump quickly"

    //System.out.println(' '+0);
    //'a'=97
    //' '=32

    /*
    执行耗时:1 ms,击败了100.00% 的Java用户
	内存消耗:39.8 MB,击败了98.91% 的Java用户
     */
    public String decodeMessage(String key, String message) {
        int[] password = getPasswordMap(key);
        char[] messageChars=message.toCharArray();
        for (int i = 0; i < messageChars.length; i++) {
            int c=messageChars[i]-97;
            if (c<0){
                messageChars[i]=' ';
            }else {
                messageChars[i] = (char) (password[c]+96);
            }
        }
        return String.valueOf(messageChars);
    }
    private int[] getPasswordMap(String key){
        int[] maps=new int[26];
        int pace=1;
        for (int i = 0; i < key.length(); i++) {
            int c =key.charAt(i)-97;
            if (c>=0&&maps[c]==0){
                maps[c]=pace++;
            }
            if (pace>26){
                return maps;
            }
        }
        return maps;
    }



    //LCUser ylb
    public String decodeMessageLCUser(String key, String message) {
        char[] d = new char[128];
        d[' '] = ' ';
        for (int i = 0, j = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (d[c] == 0) {
                d[c] = (char) ('a' + j++);
            }
        }
        char[] ans = message.toCharArray();
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = d[ans[i]];
        }
        return String.valueOf(ans);
    }
//
//    作者：ylb
//    链接：https://leetcode.cn/problems/decode-the-message/solutions/2085912/python3javacgo-yi-ti-yi-jie-shu-zu-huo-h-xsd9/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
