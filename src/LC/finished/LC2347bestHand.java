package LC.finished;

import java.util.Arrays;

public class LC2347bestHand {
    /*
    执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:38.9 MB,击败了80.61% 的Java用户
     */
    public String bestHand(int[] ranks, char[] suits) {
        if (suits[0]==suits[1]&&
                suits[1]==suits[2]&&
                suits[2]==suits[3]&&
                suits[3]==suits[4]
        ){
            return "Flush";
        }
        Arrays.sort(ranks);
        int sameCount=1;
        int maxCount=1;
        int n=ranks[0];
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i]==n){
                sameCount++;
                if (sameCount>maxCount) maxCount=sameCount;
            }else {
                n=ranks[i];
                sameCount=1;
            }
        }
        if (maxCount==1){
            return "High Card";
        }
        if (maxCount==2){
            return "Pair";
        }else {
            return "Three of a Kind";
        }
    }
}
