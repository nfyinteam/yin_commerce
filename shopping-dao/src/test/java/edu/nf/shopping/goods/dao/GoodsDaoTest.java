package edu.nf.shopping.goods.dao;

import edu.nf.shopping.goods.entity.GoodsInfo;
import edu.nf.shopping.goods.entity.GoodsType;
import edu.nf.shopping.goods.entity.SpuInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@SpringBootApplication(scanBasePackages = "edu.nf.shopping")
public class GoodsDaoTest {

    @Autowired
    private GoodsDao dao;

    @Test
    void listGoods() {
        List<GoodsInfo> list = dao.listGoods();
        for (GoodsInfo goods : list){
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
    void listGoodsByName() {
    }

    @Test
    void listGoodsBySpuId() {
    }

    @Test
    void listGoodsById() {
    }
}