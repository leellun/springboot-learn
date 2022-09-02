package com.newland.bootredis.config;

import com.google.common.hash.Funnels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
public class Ch34EurekaClientApplication {

    private static BloomFilterHelper<CharSequence> bloomFilterHelper = new BloomFilterHelper<>(Funnels.stringFunnel(Charset.defaultCharset()), 1000, 0.1);

    @Autowired
    RedisBloomFilter redisBloomFilter;

    public void run() throws Exception {
        //******* Redis集群测试布隆方法*********
        int j = 0;
        for (int i = 0; i < 100; i++) {
            redisBloomFilter.addByBloomFilter(bloomFilterHelper, "bloom", i + "");
        }
        for (int i = 0; i < 1000; i++) {
            boolean result = redisBloomFilter.includeByBloomFilter(bloomFilterHelper, "bloom", i + "");
            if (!result) {
                j++;
            }
        }
        System.out.println("漏掉了" + j + "个");
    }
}