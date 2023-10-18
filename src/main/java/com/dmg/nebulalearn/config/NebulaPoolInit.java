package com.dmg.nebulalearn.config;

import java.net.UnknownHostException;
import java.util.List;

import com.google.common.collect.Lists;
import com.vesoft.nebula.client.graph.NebulaPoolConfig;
import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.net.NebulaPool;
import io.github.anyzm.graph.ocean.mapper.NebulaGraphMapper;
import io.github.anyzm.graph.ocean.session.NebulaPoolSessionManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NebulaPoolInit {

    @Value("${nebula.pool.max.connect.size:1000}")
    private int nebulaPoolMaxConnSize;

    @Value("${nebula.pool.min.connect.size:50}")
    private int nebulaPoolMinConnSize;

    @Value("${nebula.pool.idle.time:180000}")
    private int nebulaPoolIdleTime;

    @Value("${nebula.pool.timeout:300000}")
    private int nebulaPoolTimeout;

    @Value("${nebula.cluster.address:}")
    private String nebulaCluster;

    @Value("${nebula.userName:}")
    private String userName;

    @Value("${nebula.password:}")
    private String password;

    @Value("${nebula.space:}")
    private String space;

    @Bean
    public NebulaPoolConfig nebulaPoolConfig() {
        NebulaPoolConfig nebulaPoolConfig = new NebulaPoolConfig();
        nebulaPoolConfig.setMaxConnSize(nebulaPoolMaxConnSize);
        nebulaPoolConfig.setMinConnSize(nebulaPoolMinConnSize);
        nebulaPoolConfig.setIdleTime(nebulaPoolIdleTime);
        nebulaPoolConfig.setTimeout(nebulaPoolTimeout);
        return nebulaPoolConfig;
    }

    @Bean
    public NebulaPool nebulaPool(NebulaPoolConfig nebulaPoolConfig) throws UnknownHostException {
        List<HostAddress> addresses = null;
        try {
            String[] hostPorts = StringUtils.split(nebulaCluster, ",");
            addresses = Lists.newArrayListWithExpectedSize(hostPorts.length);
            for (String hostPort : hostPorts) {
                String[] linkElements = StringUtils.split(hostPort, ":");
                HostAddress hostAddress = new HostAddress(linkElements[0], Integer.valueOf(linkElements[1]));
                addresses.add(hostAddress);
            }
        } catch (Exception e) {
            throw new RuntimeException("nebula数据库连接信息配置有误，正确格式：ip1:port1,ip2:port2");
        }
        NebulaPool pool = new NebulaPool();
        pool.init(addresses, nebulaPoolConfig);
        return pool;
    }

    @Bean
    public NebulaPoolSessionManager nebulaPoolSessionManager(NebulaPool nebulaPool) {
        return new NebulaPoolSessionManager(nebulaPool, userName, password, true);
    }
    @Bean
    public NebulaGraphMapper nebulaGraphMapper(NebulaPoolSessionManager nebulaPoolSessionManager) {
        return new NebulaGraphMapper(nebulaPoolSessionManager, space);
    }
}
