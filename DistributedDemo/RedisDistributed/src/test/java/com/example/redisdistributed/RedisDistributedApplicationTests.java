package com.example.redisdistributed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisDistributedApplicationTests {

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        int i = 0;
        try {
            long start = System.currentTimeMillis();// 开始毫秒数
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) {// 当大于等于1000毫秒（相当于1秒）时，结束操作
                    break;
                }
                i++;
                redisTemplate.opsForValue().set("test" + i, i + "");
            }
        } finally {// 关闭连接
        }
        // 打印1秒内对Redis的操作次数
        System.out.println("redis每秒操作：" + i + "次");
    }

    @Test
    void multipleUser() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    distributedTest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    distributedTest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.run();
        t2.run();
    }

    @Test
    void distributedTest() throws InterruptedException {
        System.out.println("抢购开始");
        Thread.sleep(2000);
        while (true) {
            System.out.println("尝试获得抢购权限...");
            Thread.sleep(2000);
            if (redisTemplate.opsForValue().setIfAbsent("lockKey", "t1", 40, TimeUnit.SECONDS)
            ) {
                System.out.println("获取到下单资格！");
                Thread.sleep(1000);
                System.out.println("获取商品数量");
                int i = (int) redisTemplate.opsForValue().get("goodNum");
                System.out.println("商品数量为" + i);
                Thread.sleep(1000);
                System.out.println("进行下单");
                redisTemplate.opsForValue().set("goodNum", --i);
                Thread.sleep(1000);
                System.out.println("购买成功");
                Thread.sleep(1000);
                i = (int) redisTemplate.opsForValue().get("goodNum");
                System.out.println("剩余商品数量为：" + i);
                Thread.sleep(1000);
                System.out.println("归还抢购权限...");
                Thread.sleep(800);
                if (redisTemplate.delete("lockKey")) {
                    System.out.println("归还抢购权限成功");
                } else {
                    System.out.println("归还抢购权限失败");
                }
                Thread.sleep(1000);
                System.out.println("结束本轮抢购，再见");
            } else {
                System.out.println("未能获取到抢购权限");
                Thread.sleep(1000);
                System.out.println("重新进入抢购模式");
                Thread.sleep(1000);
            }
        }
    }


//    @Test
    /*
    public class RedisLockTest {`
        private static RedisLockUtil demo = new RedisLockUtil();
        private static Integer NUM = 101;

        public static void main(String[] args) {
            for (int i = 0; i < 100; i++) {`
                new Thread(() -> {
                    String id = Thread.currentThread().getId() + "";
                    boolean isLock = demo.lock(id);
                    try {
                        // 拿到锁的话，就对共享参数减一
                        if (isLock) {
                            NUM--;
                            System.out.println(NUM);
                        }
                    } finally {
                        // 释放锁一定要注意放在finally
                        demo.unlock(id);
                    }
                }).start();
            }
        }
    }
     */
/*
    void othersLock() {
        int NUM=100;
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                String id = Thread.currentThread().getId() + "";
                boolean isLock = demo.lock(id);
                try {
                    // 拿到锁的话，就对共享参数减一
                    if (isLock) {
                        NUM--;
                        System.out.println(NUM);
                    }
                } finally {
                    // 释放锁一定要注意放在finally
                    demo.unlock(id);
                }
            }).start();
        }
    }
*/
}
