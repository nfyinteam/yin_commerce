package edu.nf.shopping.goods_search.dao;

import edu.nf.shopping.goods_search.entity.GoodsInfo;
import edu.nf.shopping.goods_search.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;

import java.util.List;

/**
 * @author 彭哥
 * @date 2020/3/24
 */
@SpringBootTest
@SpringBootApplication(scanBasePackages = {"edu.nf.shopping"})
public class Goods_SearchDaoTest {

    @Autowired
    private UsersDao dao;

    @Autowired
    private ElasticsearchRestTemplate template;

    @Autowired GoodsSearchDao goodsSearchDao;
    @Test
    void UserTest() {
        GetQuery getQuery = new GetQuery();
        getQuery.setId("1");
        Users user = template.queryForObject(getQuery, Users.class);
        System.out.println("userId:"+user.getId());
        System.out.println("userName："+user.getName());
        System.out.println("userAge："+user.getAge());
        System.out.println("userBirthplace："+user.getBirthplace());

    }
    @Test
    void listGoodsSearchByNameTest() {
        List<GoodsInfo> list = goodsSearchDao.listGoodsSearchByName("A");
        for (GoodsInfo goods : list) {
            System.out.print("goods_id:" + goods.getGoodsId() + "/");
            System.out.print("goods_name:" + goods.getGoodsId() + "/");
            System.out.print("shelf_time:" + goods.getShelfTime() + "/");
            System.out.print("is_shelf:" + goods.getIsShelf() + "/");
            System.out.print("spu_id:" + goods.getSpuId() + "/");
            System.out.println("gt_id:" + goods.getGtId());
        }
    }

}
