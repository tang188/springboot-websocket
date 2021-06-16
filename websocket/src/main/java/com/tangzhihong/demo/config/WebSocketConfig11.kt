package com.tangzhihong.demo.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

/**
 * Class description:
 */
@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig11 : WebSocketMessageBrokerConfigurer {

    @Value("\${ws.stomp.url}")
    private val wsStompUrl: String? = null

    @Value("\${ws.stomp.topic.prefix}")
    private val wsStompTopicPrefix: String? = null

    override fun registerStompEndpoints(stompEndpointRegistry: StompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint(wsStompUrl) //解决跨域问题
                .setAllowedOrigins("*")
                .withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker(wsStompTopicPrefix)
    }
}