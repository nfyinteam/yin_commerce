package edu.nf.shopping.shopcart.service;

import edu.nf.shopping.goods.entity.ValueInfo;
import edu.nf.shopping.shopcart.entity.ShopCartGoods;
import edu.nf.shopping.shopcart.entity.ShopCartGoodsAttribute;
import edu.nf.shopping.shopcart.entity.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class ShoppingCartDaoTest {

    @Autowired
    private ShopCartService service;

    @Test
    void listShoppingCart() {
        List<ShopCartGoods> list=service.listShoppingCart("1578412684666");
        for (ShopCartGoods s:list
             ) {
            System.out.println(s.getGoodsName());
            System.out.println(s.getImgFile());
            System.out.println(s.getJoinTime());
            System.out.println(s.getScId());
            System.out.println(s.getSkuId());
            System.out.println(s.getSkuPrice());
            System.out.println(s.getSkuStock());
            for (ShopCartGoodsAttribute sa: s.getScga()
                 ) {
                System.out.println(sa.getKeyId());
                System.out.println(sa.getKeyName());
                System.out.println(sa.getValueName());
            }

        }
    }

    @Test
    void deleteShoppingCart() {
        service.deleteShoppingCart("1");
    }

    @Test
    void deleteShoppingCartList() {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        service.deleteShoppingCartList(list);
    }

    @Test
    void findShoppingCart() {
        List<ShopCartGoods> list=service.findShoppingCart("1578412684666",1);
        for (ShopCartGoods s:list
        ) {
            System.out.println(s.getGoodsName());
            System.out.println(s.getImgFile());
            System.out.println(s.getJoinTime());
            System.out.println(s.getScId());
            System.out.println(s.getSkuId());
            System.out.println(s.getSkuPrice());
            System.out.println(s.getSkuStock());
            for (ShopCartGoodsAttribute sa: s.getScga()
            ) {
                System.out.println(sa.getKeyId());
                System.out.println(sa.getKeyName());
                System.out.println(sa.getValueName());
            }

        }
    }

    @Test
    void addShoppingCart() {
        ShoppingCart sc=new ShoppingCart();
        sc.setUid("1578412684666");
        String uuid=UUID.randomUUID().toString().replace("-", "").toLowerCase();
        sc.setScId("2");
        sc.setSkuId("1577706998213");
        service.addShoppingCart(sc);
    }

    @Test
    void listValueInfo(){
        List<ValueInfo> list=service.listValueInfo();
        for (ValueInfo v:list
             ) {
            System.out.println(v.getValueId());
            System.out.println(v.getValueName());
        }
    }

    @Test
    void findShopCartGoods(){
        ShopCartGoods sg=service.findeShopCartGoods("1578412684666","1577706998213","36.5");
        System.out.println(sg);
    }
}