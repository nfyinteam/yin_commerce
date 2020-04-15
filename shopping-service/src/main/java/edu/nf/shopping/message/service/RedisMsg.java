package edu.nf.shopping.message.service;

import edu.nf.shopping.message.entity.News;
import org.springframework.stereotype.Component;

/**
 * @author Bull fighters
 * @date 2020/4/15
 */
@Component
public interface RedisMsg {
    /**
     * 接受信息
     * @param news
     */
    public void receiveMessage(News news);
}