package edu.nf.shopping.goods.service;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import edu.nf.shopping.goods.entity.GoodsAllInfo;
import edu.nf.shopping.goods.entity.GoodsInfo;
import edu.nf.shopping.goods.entity.GoodsType;
import edu.nf.shopping.goods.entity.SpuInfo;
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
    private GoodsService service;

    @Autowired
    private GoodsAllInfoService goodsAllInfoService;

    @Test
    public void listGoodsTest(){
        List<GoodsInfo> list = service.listGoods();
        for (GoodsInfo goods : list) {
            System.out.println("goods_id:" + goods.getGoodsId());
            System.out.println("goods_name:" + goods.getGoodsId());
            System.out.println("shelf_time:" + goods.getShelfTime());
            System.out.println("is_shelf" + goods.getIsShelf());
            SpuInfo spuInfo = goods.getSpuInfo();
            System.out.println("spu_id:" + spuInfo.getSpuId());
            System.out.println("spu_name:" + spuInfo.getSpuName());
            System.out.println("spu_remark:" + spuInfo.getSpuRemark());
            System.out.println("list_time:" + spuInfo.getListTime());
            System.out.println("spu_num:" + spuInfo.getSpuNum());
            GoodsType goodsType = goods.getGoodsType();
            System.out.println("gt_id:" + goodsType.getGtId());
            System.out.println("gt_name:" + goodsType.getGtName());
            System.out.println("p_id:" + goodsType.getPId());
            System.out.println("----------------------------");
        }
    }

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
    }


}
