package edu.nf.shopping.goods.service;

import edu.nf.shopping.goods.entity.GoodsInfo;
import edu.nf.shopping.goods.entity.GoodsType;
import edu.nf.shopping.goods.entity.SpuInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/6
 */
@SpringBootTest
@SpringBootApplication(scanBasePackages = {"edu.nf.shopping"})
public class GoodsServiceTest {

    @Autowired
    private GoodsService service;

    @Test
    void listGoodsTest(){
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
}
