package edu.nf.shopping.shopcart.service;

import edu.nf.shopping.goods.entity.ValueInfo;
import edu.nf.shopping.shopcart.entity.ShopCartGoods;
import edu.nf.shopping.shopcart.entity.ShoppingCart;

import java.util.List;

/**
 * @author Vera
 * @date 2020/3/24
 */
public interface ShopCartService {
    /**
     * 根据用户id查询该用户购物车所有商品
     * @param uid
     * @return
     */
    List<ShopCartGoods> listShoppingCart(String uid);

    /**
     * 删除购物车商品
     */
    void deleteShoppingCart(String scId);

    /**
     * 批量删除购物车商品
     * @param scIds
     */
    void deleteShoppingCartList(List<String> scIds);


    /**
     * 根据品牌筛选中购物车对应品牌的商品
     * @param uid
     * @param valueId
     * @return
     */
    List<ShopCartGoods> findShoppingCart(String uid, Integer valueId);

    /**
     * 添加商品到购物车
     * @param shoppingCart
     */
    void addShoppingCart(ShoppingCart shoppingCart);

    /**
     * 列出所有品牌
     * @return
     */
    List<ValueInfo> listValueInfo();

    /**
     * 查找购物车是否已有该鞋码的商品
     * @param uid
     * @param skuId
     * @param valueName
     * @return
     */
    ShopCartGoods findeShopCartGoods(String uid,String skuId,String valueName);
}
