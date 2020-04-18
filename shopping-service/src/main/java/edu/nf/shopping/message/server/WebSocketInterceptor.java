package edu.nf.shopping.message.server;

import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.util.LettuceUtils;
import io.lettuce.core.api.sync.RedisCommands;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Bull fighters
 * @date 2020/4/9
 */
@Component
public class WebSocketInterceptor extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse seHttpResponse,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
		HttpServletRequest request = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();
        String customerService= serverHttpRequest.getURI().toString().split("service=")[1];
        //从作用域获取用户编号
		UserInfo userId=(UserInfo) request.getSession().getAttribute("userInfo");
		userId.setNecessaryCustomerService(customerService);
        if(userId!=null){
            attributes.put("userInfo", userId);
        }
        System.out.println("用户："+userId);
        return super.beforeHandshake(serverHttpRequest, seHttpResponse, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception ex) {
        super.afterHandshake(request, response, wsHandler, ex);
    }
}