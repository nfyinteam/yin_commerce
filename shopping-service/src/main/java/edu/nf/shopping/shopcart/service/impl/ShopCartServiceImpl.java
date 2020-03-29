package edu.nf.shopping.shopcart.service.impl;

import edu.nf.shopping.goods.entity.ValueInfo;
import edu.nf.shopping.shopcart.dao.ShoppingCartDao;
import edu.nf.shopping.shopcart.entity.ShopCartGoods;
import edu.nf.shopping.shopcart.entity.ShoppingCart;
import edu.nf.shopping.shopcart.exception.ShopCartException;
import edu.nf.shopping.shopcart.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vera
 * @date 2020/3/24
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShoppingCartDao dao;

    @Override
    public List<ShopCartGoods> listShoppingCart(String uid) {
        try{
            List<ShopCartGoods> list=dao.listShoppingCart(uid);
            return list;
        }catch (Exception e){
            throw new ShopCartException("根据用户id查找该用户的购物车商品失败！");
        }

    }

    @Override
    public void deleteShoppingCart(String scId) {
        try{
            dao.deleteShoppingCart(scId);
        }catch (Exception e){
            throw new ShopCartException("删除购物车商品失败！");
        }


    }

    @Override
    public void deleteShoppingCartList(List<String> scIds) {
        try{
            dao.deleteShoppingCartList(scIds);
        }catch (Exception e){
            throw new ShopCartException("批量删除购物车商品失败！");
        }
    }



    @Override
    public List<ShopCartGoods> findShoppingCart(String uid,Integer valueId) {
        try{
            List<ShopCartGoods> list=dao.findShoppingCart(uid,valueId);
            return list;
        }catch (Exception e){
            throw new ShopCartException("商品根据品牌分离失败！");
        }
    }

    @Override
    public void addShoppingCart(ShoppingCart shoppingCart) {
        try{
            dao.addShoppingCart(shoppingCart);
        }catch (Exception e){
            throw new ShopCartException("加入购物车失败！");
        }
    }

    @Override
    public List<ValueInfo> listValueInfo() {
        try{
            List<ValueInfo> list=dao.listValueInfo();
            return list;
        }catch (Exception e){
            throw new ShopCartException("列出品牌失败！");
        }
    }

    @Override
    public ShopCartGoods findeShopCartGoods(String uid, String skuId, String valueName) {
        try{
            ShopCartGoods sg=dao.findShopCartGoods(uid,skuId,valueName);
            return sg;
        }catch (Exception e){
            throw new ShopCartException("查找购物车是否有该鞋码商品失败！");
        }
    }
}
