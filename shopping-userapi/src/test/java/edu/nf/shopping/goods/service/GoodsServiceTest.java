package edu.nf.shopping.goods.service;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import edu.nf.shopping.goods.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/6
 */
@SpringBootTest
public class GoodsServiceTest {
    @Autowired
    private GoodsAllInfoService goodsAllInfoService;

    @Test
    public void getGoodsAllInfo(){
        GoodsAllInfo goodsAllInfo = goodsAllInfoService.getGoodsInfoById("1578412684904");
        GoodsInfo goodsInfo = goodsAllInfo.getGoodsInfo();
        System.out.println("goodId:" + goodsInfo.getGoodsId());
        System.out.println("goodName:" + goodsInfo.getGoodsName());
        System.out.println("shelfTime:" + goodsInfo.getShelfTime());
        System.out.println("isShelf:" + goodsInfo.getIsShelf());
        SpuInfo spuInfo = goodsInfo.getSpuInfo();
        System.out.println("spuId:" + spuInfo.getSpuId());
        System.out.println("spuName:" + spuInfo.getSpuName());
        System.out.println("spuNum:" + spuInfo.getSpuNum());
        System.out.println("spuRemark:" + spuInfo.getSpuRemark());
        System.out.println("listTime:" + spuInfo.getListTime());
        for (SkuRelation relation : goodsAllInfo.getSkuRelations()){
            System.out.println(relation.getSkuInfo().getSkuId());
            System.out.println(relation.getSkuInfo().getSkuPrice());;
        }
    }
}
