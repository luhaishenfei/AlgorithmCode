package LC.finished;

public class LC1812squareIsWhite {
    public static void main(String[] args) {


    }
    /*
    轻松秒杀
    执行耗时:0 ms,击败了100.00% 的Java用户
    内存消耗:39 MB,击败了91.87% 的Java用户
     */
    public boolean squareIsWhite(String coordinates) {
        return ( coordinates.charAt(0) + coordinates.charAt(1))%2==0?false:true;
    }

}
