package edu.nf.shopping.shopcart.entity;

import edu.nf.shopping.goods.entity.SkuRelation;

import java.util.Date;

/**
 * @author Vera
 * @date 2020/3/9
 */
public class ShoppingCart {
    private Integer scId;
    private SkuRelation relation;
    private Integer uid;
    private Date joinTime;

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public SkuRelation getRelation() {
        return relation;
    }

    public void setRelation(SkuRelation relation) {
        this.relation = relation;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}
