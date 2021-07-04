package com.leekoko.mq_demo.subscribe;

import com.leekoko.mq_demo.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

public class Receiver2 {
    private final  static  String QUEUE_NAME = "queue_routing2";
    private final static String EXCHANGE_NAME = "exchange_direct";

    public static void main(String[] args) throws IOException, InterruptedException {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false,false,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"key2");

        channel.basicQos(1);

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, false, consumer);

        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[x] Received2 "+message);
            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }


    }

}
