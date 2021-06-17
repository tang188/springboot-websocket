package com.tangzhihong.demo.nati.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.server.standard.ServerEndpointExporter

/**
 *
 * @author: Malphite
 * @date: 2021/6/16 8:15 下午
 * @version: 1.0
 * @group:
 */
@Configuration
class WebSocketConfig {

    @Bean
    fun serverEndpointExporter() : ServerEndpointExporter {
        return ServerEndpointExporter()
    }
}