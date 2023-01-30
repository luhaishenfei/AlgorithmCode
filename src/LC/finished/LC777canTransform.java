package LC.finished;

public class LC777canTransform {

    //only LC method is right,take too long time to do it ,tired,so ,just skip it.
    public static void main(String[] args) {
        LC777canTransform l = new LC777canTransform();
        boolean res = l.canTransformLC("RXXLRXRXL", "XRLXXRRLX");
        String start = "RXXLRXRXL";
        char[] chars = start.toCharArray();
        chars[0] = 'L';
        chars[1] = 'X';
        String s2 = new String(chars);
        System.out.println(s2 + "," + start);

    }

    // LC  双指针
    public boolean canTransformLC(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }


    //XL -> LX
    //RX -> XR

    //X  take LR as people ,that  XXLXX->XLXX means a L people move to left,same as right.
    public boolean canTransform(String start, String end) {
        int startIdx=0;
        int endIdx = 0;
        int startChar=0;
        int endChar=0;
        while (startIdx!=start.length()&&endIdx!=end.length()){
            while (startIdx<start.length()){
                startChar=start.charAt(startIdx);
                if (startChar=='X'){
                    startIdx++;
                }else {
                    break;
                }
            }
            while (endIdx<start.length()){
                endChar=end.charAt(endIdx);
                if (endChar=='X'){
                    endIdx++;
                }else {
                    break;
                }
            }

            if (startChar!=endChar){
                return false;
            }else {
                startIdx++;
                endIdx++;
            }
        }
        return true;
    }

    private boolean isStringEquals(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    //ok ,but too slow ,out of time
    public boolean canTransform1(String start, String end) {
        return canTransform1(start, end, 0);
    }

    public boolean canTransform1(String start, String end, int idx) {
        if (isStringEquals(start, end)) return true;
        for (int i = idx; i < start.length() - 1; i++) {
            if (start.charAt(i) == 'X' && start.charAt(i + 1) == 'L') {
                char[] chars = start.toCharArray();
                chars[i] = 'L';
                chars[i + 1] = 'X';
                if (canTransform1(new String(chars), end)) return true;
            } else if (start.charAt(i) == 'R' && start.charAt(i + 1) == 'X') {
                char[] chars = start.toCharArray();
                chars[i] = 'X';
                chars[i + 1] = 'R';
                if (canTransform1(new String(chars), end)) return true;
            }
        }
        return false;
    }


}
