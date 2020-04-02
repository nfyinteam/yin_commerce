package edu.nf.shopping.search.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author 彭哥
 * @date 2020/3/23
 */
@Document(indexName = "users",type = "_doc")
public class GoodsImgs {

    @Id
    private String imgId;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String goodsId;
    @Field(type = FieldType.Integer)
    private Integer imgIndex;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getImgIndex() {
        return imgIndex;
    }

    public void setImgIndex(Integer imgIndex) {
        this.imgIndex = imgIndex;
    }
}
