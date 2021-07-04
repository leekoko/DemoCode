package com.leekoko.mq_demo.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by apple on 2018/9/4.
 */
public class ConnectionUtil {
    public static Connection getConnection() throws IOException {
        //连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.0.24");
        //连接5672端口  注意15672为工具界面端口  25672为集群端口
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("eda");
        factory.setPassword("123456");
        //获取连接
        Connection connection = factory.newConnection();

        return connection;

    }
}
