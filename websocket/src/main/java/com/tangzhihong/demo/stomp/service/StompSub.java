package com.tangzhihong.demo.stomp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;

import java.util.concurrent.ExecutionException;

/**
 * @author: Malphite
 * @date: 2021/6/17 8:37 下午
 * @version: 1.0
 * @group:
 */
public class StompSub {


    @Autowired
    private WebSocketStompClient stompClient;

    public void test() throws ExecutionException, InterruptedException {
        StompSessionHandler sessionHandler = new CustmStompSessionHandler();

        StompSession stompSession = stompClient.connect("loggerServerQueueUrl", sessionHandler).get();

        stompSession.send("topic/greetings", "Hello new user");

    }
}
