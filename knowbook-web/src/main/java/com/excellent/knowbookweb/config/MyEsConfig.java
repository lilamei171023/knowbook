package com.excellent.knowbookweb.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * @User: Rowena
 * @Date: 2018/8/16
 * Description:
 */
@Configuration
public class MyEsConfig {
    @Bean
    public TransportClient client()throws Exception{

        InetSocketTransportAddress node = new InetSocketTransportAddress(
                InetAddress.getByName("127.0.0.1"),9300);

        Settings settings = Settings.builder().put("cluster.name","master").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }
}
