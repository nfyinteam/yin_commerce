package edu.nf.shopping.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Achine
 * @date 2020/3/13
 */
@Configuration
public class RestConfig {

    /**
     * 装配连接管理器
     * @return
     */
    @Bean
    public PoolingHttpClientConnectionManager connectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        //设置最大连接数
        connectionManager.setMaxTotal(500);
        //设置路由默认最大并发数
        connectionManager.setDefaultMaxPerRoute(100);
        return connectionManager;
    }

    public HttpComponentsClientHttpRequestFactory httpRequestFactory(){
        HttpClientBuilder builder = HttpClientBuilder.create();
        //注入连接管理器
        builder.setConnectionManager(connectionManager());
        //设置重试次数
        builder.setRetryHandler(new DefaultHttpRequestRetryHandler(2, true));
        HttpClient httpClient = builder.build();
        //创建HttpComponentsClientHttpRequestFactory
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        // 连接超时
        httpRequestFactory.setConnectTimeout(20000);
        // 数据读取超时时间
        httpRequestFactory.setReadTimeout(20000);
        // 连接等待超时时间
        httpRequestFactory.setConnectionRequestTimeout(200);
        return httpRequestFactory;
    }

    /**
     * 装配RestTemplate
     * @return
     */
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        //注入HttpComponentsClientHttpRequestFactory
        restTemplate.setRequestFactory(httpRequestFactory());
        return restTemplate;
    }

}
