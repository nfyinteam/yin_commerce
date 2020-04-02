package edu.nf.shopping.shopcart;

import edu.nf.shopping.goods.entity.SkuInfo;
import edu.nf.shopping.goods.entity.SkuRelation;
import edu.nf.shopping.shopcart.entity.ShopCartGoods;
import edu.nf.shopping.shopcart.entity.ShoppingCart;
import edu.nf.shopping.shopcart.service.ShopCartService;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.util.UUIDUtils;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Vera
 * @date 2020/4/2
 */
@RestController
public class ShopCartController extends BaseController {

    @Autowired
    private ShopCartService service;

    @GetMapping("/list/all/shopcart/goods")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public ResponseVO listAllShopCartGoods(HttpSession session){
        UserInfo user= (UserInfo) session.getAttribute("user");
        List<ShopCartGoods> list=service.listShoppingCart(user.getUserId());
        if(list!=null){
            return success(list);
        }
        return fail(305,"购物车为空");
    }

    @DeleteMapping("/deletegoods")
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE})
    public ResponseVO deleteSingleShopCartGoods(String scId){
        service.deleteShoppingCart(scId);
        return success(200);
    }

    @DeleteMapping("/delete/lot/goods")
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE})
    public ResponseVO deleteLotShopCartGoods(@RequestBody @RequestParam("scIds[]") List<String> scIds){
        service.deleteShoppingCartList(scIds);
        return success(200);
    }


    @GetMapping("/find/goods/brand")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public ResponseVO findShopCartGoodsByBrand(String uid, Integer valueId){
        List<ShopCartGoods> list=service.findShoppingCart(uid,valueId);
        if(list!=null){
            return success(list);
        }
        return fail(304,"您购物车没用该品牌的商品！");
    }

    /**
     * 加入购物车
     * @param uid
     * @param skuId
     * @param valueName
     * @return
     */
    @PutMapping("/add/goods")
    @CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
    public ResponseVO addShopCartGoods(HttpSession session, String skuId, String valueName){
        UserInfo userInfo = (UserInfo)session.getAttribute("user");
        if(userInfo == null){
            return fail(500,"对不起，您购物车已有该商品！");
        }
        ShopCartGoods shopCartGoods=service.findeShopCartGoods(userInfo.getUserId(), skuId, valueName);
        if(shopCartGoods==null){
            String uuid=UUIDUtils.createUUID();
            ShoppingCart shoppingCart=new ShoppingCart();
            SkuRelation skuRelation=new SkuRelation();
            SkuInfo skuInfo=new SkuInfo();
            shoppingCart.setUid(userInfo.getUserId());
            shoppingCart.setScId(uuid);
            skuInfo.setSkuId(skuId);
            skuRelation.setSkuInfo(skuInfo);
            service.addShoppingCart(shoppingCart);
            return success(200,"加入购物车成功！");
        }
        return fail(303,"对不起，您购物车已有该商品！");



    }




}
