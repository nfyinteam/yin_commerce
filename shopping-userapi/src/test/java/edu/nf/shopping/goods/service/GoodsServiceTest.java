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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        GoodsAllInfo goodsAllInfo = goodsAllInfoService.getGoodsInfoById("1578412684905");
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
        Map<String, List<ValueInfo>> map = new HashMap<>();
        for (SkuRelation relation : goodsAllInfo.getSkuRelations()){
            List<ValueInfo> list = map.get(relation.getKey().getKeyName());
            if(list == null){
                list = new ArrayList<>();
                map.put(relation.getKey().getKeyName(), list);
            }
            ValueInfo valueInfo = relation.getValue();
            SkuInfo skuInfo = relation.getSkuInfo();
            valueInfo.setSkuInfo(skuInfo);
            list.add(valueInfo);
            map.put(relation.getKey().getKeyName(), list);
        }
        for (String key : map.keySet()){
            System.out.println("key:" + key);
            List<ValueInfo> list = map.get(key);
            for (ValueInfo info : list){
                System.out.println("valueID:" + info.getValueId());
                System.out.println("value:" + info.getValueName());
                System.out.println("skuId:" + info.getSkuInfo().getSkuId());
                System.out.println("skuStock:" + info.getSkuInfo().getSkuStock());
            }
            System.out.println("----------------------");
        }
        for (GoodsImgs img : goodsAllInfo.getGoodsImgs()){
            System.out.println(img.getImgIndex());
        }
    }
}
