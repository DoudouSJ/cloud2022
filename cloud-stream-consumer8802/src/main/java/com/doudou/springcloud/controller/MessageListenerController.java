package com.doudou.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;

/**
 * @author Doudou
 * @date 2022/3/28 - 23:58
 */
@Controller
@EnableBinding(Sink.class)
public class MessageListenerController {

    @Value("${server.port}")
    private String port;

    public void input(Message<String> message){
        System.out.println("接受消息："+message.getPayload()+"--端口号："+port);
    }

}
