package com.tangzhihong.demo.stomp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author: Malphite
 * @date: 2021/6/17 8:35 下午
 * @version: 1.0
 * @group:
 * https://cloud.tencent.com/developer/article/1451314
 */
@RestController
public class StompController {

    // @MessageMapping 和 @RequestMapping 功能类似，浏览器向服务器发起消息，映射到该地址。
    @MessageMapping("/app")
    // 如果服务器接受到了消息，就会对订阅了 @SendTo 括号中的地址的浏览器发送消息。
    @SendTo("/topic/broadcast")
    public String say(@Payload String message) throws Exception {
        return "hello " + message;
    }

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/app")
    // 如果服务器接受到了消息，就会对订阅了 @SendTo 括号中的地址的浏览器发送消息。
    public void broadcastNews(@Payload String message) {
        simpMessagingTemplate.convertAndSend("/topic/bc", message);
    }

    @MessageMapping("/greetings")
    @SendToUser("/queue/greetings")
    public String reply(@Payload String message,   Principal user) { return  "Hello " + message;}


}
