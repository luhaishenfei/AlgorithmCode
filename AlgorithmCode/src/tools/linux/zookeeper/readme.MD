1.多集群时，myid从小到大依次启动时：
总数5，则id=3的为leader
总数7，则id=4的为leader  
总数2n+1,则id=n+1为leader
（投票刚好过半数的时候为leader）