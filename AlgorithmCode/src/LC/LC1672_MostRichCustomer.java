package LC;

public class LC1672_MostRichCustomer {
    public static void main(String[] args) {
        int[][] ac = {{1,2,3},{2,3,4}};
        LC1672_MostRichCustomer l=new LC1672_MostRichCustomer();
        System.out.println(l.maximumWealth(ac));
    }

    public int maximumWealth(int[][] accounts) {
        int max=-1;
        for (int i = 0; i < accounts.length; i++) {
            int maxNow=0;
            for (int j = 0; j < accounts[i].length; j++) {
                maxNow+=accounts[i][j];
            }
            if (maxNow>max){
                max=maxNow;
            }
        }
        return max;
    }

}
