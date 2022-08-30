package com.newland.bootredis.config;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Guava版布隆过滤器
 * 特别注意：Guava 提供的布隆过滤器，有个很大的缺陷就是只能单机使用。为了解决这个问题，后面可以考虑使用 Redis 提供的布隆过滤器。
 */
public class BloomFilterTest {
    /**
     * @param expectedInsertions 预期插入值
     *                           这个值的设置相当重要，如果设置的过小很容易导致饱和而导致误报率急剧上升，如果设置的过大，也会对内存造成浪费，所以要根据实际情况来定
     * @param fpp                误差率，例如：0.001,表示误差率为0.1%
     * @return 返回true，表示可能存在，返回false一定不存在
     */
    public static boolean isExist(int expectedInsertions, double fpp) {
        // 创建布隆过滤器对象
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), expectedInsertions, fpp);

        // 判断指定元素是否存在
        System.out.println(filter.mightContain(10));

        // 将元素添加进布隆过滤器
        filter.put(10);

        // 再判断指定元素是否存在
        System.out.println(filter.mightContain(10));
        return filter.mightContain(10);
    }

    public static void main(String[] args) {

        boolean exist = isExist(100000000, 0.001);
    }
}
