package edu.nf.shopping.config;

import edu.nf.shopping.message.server.WebSocketHandlerImpl;
import edu.nf.shopping.message.server.WebSocketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author Bull fighters
 * @date 2020/4/6
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocketHandlerImpl webSocketHandler;

    @Autowired
    private WebSocketInterceptor webSocketInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //handler是webSocket的核心，配置入口
        registry.addHandler(webSocketHandler, "/websocket/{customerService}")
                .setAllowedOrigins("*").addInterceptors(webSocketInterceptor);
    }
}