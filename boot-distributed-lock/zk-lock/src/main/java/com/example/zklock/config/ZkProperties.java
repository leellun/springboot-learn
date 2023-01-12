package com.example.zklock.config;

import lombok.Data;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.IOException;

@Data
@ConfigurationProperties(prefix = "zk")
public class ZkProperties {
    private String connectString;
    private CuratorProperties curator;

    @Data
    public static class CuratorProperties {
        private int retryCount;
        private int elapsedTimeMs;
        private int sessionTimeoutMs;
        private int connectionTimeoutMs;
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zookeeper = new ZooKeeper(
                "192.168.100.100:2181,192.168.100.100:2182,192.168.100.100:2183",
                10000,
                new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        System.out.println(watchedEvent);
                    }
                });
        System.out.println(zookeeper.getChildren("/",false));
    }
}
