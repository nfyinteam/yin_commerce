package edu.nf.shopping.goods_search.service;

import edu.nf.shopping.goodsearch.entity.GoodsSearch;
import edu.nf.shopping.goodsearch.service.GoodsSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 彭哥
 * @date 2020/4/2
 */
@SpringBootTest
@SpringBootApplication(scanBasePackages = {"edu.nf.shopping"})
public class GoodsSaerchServiceTest {
    @Autowired
    private GoodsSearchService service;

    @Test
    void GoodsSearchByNameTest(){
        List<GoodsSearch> list = service.listGoodsSearchByName("A");
        for (GoodsSearch goods :list) {
            System.out.print("goods_name:" + goods.getGoodsName()+"/");
            System.out.print("sku_price:" + goods.getSkuPrice()+"/");
            System.out.print("img_file:" + goods.getImgFile());
        }
    }
}
