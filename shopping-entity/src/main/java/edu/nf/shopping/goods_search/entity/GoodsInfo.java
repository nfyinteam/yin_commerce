package edu.nf.shopping.goods_search.entity;





import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author 彭哥
 * @date 2020/3/23
 */

@Document(indexName = "users",type = "_doc")
public class GoodsInfo {

    @Id
    private String goodsId;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String goodsName;
    @Field(type = FieldType.Date)
    private Date shelfTime;
    @Field(type = FieldType.Byte)
    private Byte isShelf;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String spuId;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String gtId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Date getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(Date shelfTime) {
        this.shelfTime = shelfTime;
    }

    public Byte getIsShelf() {
        return isShelf;
    }

    public void setIsShelf(Byte isShelf) {
        this.isShelf = isShelf;
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public String getGtId() {
        return gtId;
    }

    public void setGtId(String gtId) {
        this.gtId = gtId;
    }
}
