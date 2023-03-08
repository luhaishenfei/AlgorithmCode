package LC.finished.LC1797AuthenticationManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，这个验证码在 currentTime 时刻之后 timeToLive 秒过期。如
//果验证码被更新了，那么它会在 currentTime （可能与之前的 currentTime 不同）时刻延长 timeToLive 秒。
//
// 请你实现 AuthenticationManager 类：
//
//
// AuthenticationManager(int timeToLive) 构造 AuthenticationManager 并设置
//timeToLive 参数。
// generate(string tokenId, int currentTime) 给定 tokenId ，在当前时间 currentTime 生成一个新
//的验证码。
// renew(string tokenId, int currentTime) 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻
//更新。如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
// countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。
//


// too slow
//	执行耗时:76 ms,击败了9.80% 的Java用户
//	内存消耗:43 MB,击败了40.00% 的Java用户
class AuthenticationManager {
    private int timeToLive;


    //此处可将Timer类优化成Integer
    private Map<String,Timer> manageMap;


    public AuthenticationManager(int timeToLive) {
        this.timeToLive=timeToLive;
        this.manageMap=new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        manageMap.put(tokenId,new Timer(currentTime,currentTime+timeToLive));
    }

    public void renew(String tokenId, int currentTime) {
        Timer timer = manageMap.get(tokenId);
        if (timer!=null&&timer.startTime<=currentTime&&timer.endTime>currentTime){
            timer.startTime=currentTime;
            timer.endTime=currentTime+timeToLive;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        Set<String> keySet = manageMap.keySet();
        int count=0;
        for (String tokenId:keySet
             ) {
            Timer timer = manageMap.get(tokenId);
            if (timer.startTime<=currentTime&&timer.endTime>currentTime) count++;
        }
        return count;
    }

    private class Timer{
        private int startTime;
        private int endTime;
        public Timer(int startTime,int endTime){
            this.startTime=startTime;
            this.endTime=endTime;
        }
    }
}