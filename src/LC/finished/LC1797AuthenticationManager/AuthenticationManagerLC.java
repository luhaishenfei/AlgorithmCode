package LC.finished.LC1797AuthenticationManager;

import java.util.HashMap;
import java.util.Map;
//执行耗时:57 ms,击败了43.92% 的Java用户
//内存消耗:42.9 MB,击败了50.59% 的Java用户
class AuthenticationManagerLC {
    int timeToLive;
    Map<String, Integer> map;

    public AuthenticationManagerLC(int timeToLive) {
        this.timeToLive = timeToLive;
        this.map = new HashMap<String, Integer>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.getOrDefault(tokenId, 0) > currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (int time : map.values()) {
            if (time > currentTime) {
                res++;
            }
        }
        return res;
    }
}
