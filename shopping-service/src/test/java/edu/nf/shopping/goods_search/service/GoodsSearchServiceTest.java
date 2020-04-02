package edu.nf.shopping.goods_search.service;

import edu.nf.shopping.goods_search.entity.GoodsInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 彭哥
 * @date 2020/3/28
 */
@SpringBootTest
@SpringBootApplication(scanBasePackages = {"edu.nf.shopping"})
public class GoodsSearchServiceTest {
    @Autowired
    private GoodsSearchService service;

    @Test
    void listGoodsSearchByNameTest(){
        List<GoodsInfo> list = service.listGoodsSearchByName("A");
        for (GoodsInfo goods :list) {
            System.out.print("goods_id:" + goods.getGoodsId()+"/");
            System.out.print("goods_name:" + goods.getGoodsId()+"/");
            System.out.print("shelf_time:" + goods.getShelfTime()+"/");
            System.out.print("is_shelf:" + goods.getIsShelf()+"/");
            System.out.print("spu_id:"+goods.getSpuId()+"/");
            System.out.println("gt_id:"+goods.getGtId());
        }
    }
}
