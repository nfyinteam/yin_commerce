package edu.nf.shopping.goodsearch.dao;
import edu.nf.shopping.search.entity.GoodsInfo;
import edu.nf.shopping.user.entity.UserInfo;
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
public class GoodsSearchDaoTest {

    @Autowired
    private UsersDao dao;

    @Autowired
    private ElasticsearchRestTemplate template;

    @Autowired GoodsSearchDao goodsSearchDao;
    @Test
    void UserTest() {
        GetQuery getQuery = new GetQuery();
        getQuery.setId("1");
        UserInfo user = template.queryForObject(getQuery, UserInfo.class);
        System.out.println("userId:"+user.getUid());
        System.out.println("userName："+user.getUserName());
        System.out.println("userSex："+user.getUserSex());
        System.out.println("userEmail："+user.getUserEmail());

    }
    @Test
    void listGoodsSearchByNameTest() {
        /*List<GoodsInfo> list = goodsSearchDao.listGoodsSearchByName("A");
        for (GoodsInfo goods : list) {
            System.out.print("goods_id:" + goods.getGoodsId() + "/");
            System.out.print("goods_name:" + goods.getGoodsId() + "/");
            System.out.print("shelf_time:" + goods.getShelfTime() + "/");
            System.out.print("is_shelf:" + goods.getIsShelf() + "/");
            System.out.print("spu_id:" + goods.getSpuId() + "/");
        }*/
    }

}
