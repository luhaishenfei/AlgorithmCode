package LC.finished.LC1797AuthenticationManager;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Demo {
    public static void main(String[] args) {
//["AuthenticationManager","renew","generate","countUnexpiredTokens","generate","renew","renew","countUnexpiredTokens"]
//			[[5],["aaa",1],["aaa",2],[6],["bbb",7],["aaa",8],["bbb",10],[15]]
        AuthenticationManager authenManager=new AuthenticationManager(5);
        authenManager.renew("aaa",1);
        authenManager.generate("aaa",2);
        authenManager.countUnexpiredTokens(6);
        authenManager.generate("bbb",7);
        authenManager.renew("aaa",8);
        authenManager.renew("bbb",10);

        authenManager.countUnexpiredTokens(15);



         Queue<int[]> timerQueue=new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else {
                    return o2[1]-o1[1];
                }
            }
        });

        timerQueue.add(new int[]{1,10});
        timerQueue.add(new int[]{2,7});
        timerQueue.add(new int[]{3,5});
        timerQueue.add(new int[]{2,3});
        while (!timerQueue.isEmpty()){
            int[] i=timerQueue.poll();
            System.out.println(i[1]);
        }
        System.out.println(timerQueue);
        System.out.println(timerQueue);
    }
}
