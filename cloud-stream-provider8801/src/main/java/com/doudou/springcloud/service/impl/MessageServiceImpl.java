package com.doudou.springcloud.service.impl;

import com.doudou.springcloud.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @author Doudou
 * @date 2022/3/28 - 11:47
 */
@EnableBinding(Source.class)
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageChannel output;
    @Override
    public String send() {
        String uuId = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuId).build());
        return uuId;
    }
}
