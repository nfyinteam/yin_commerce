package edu.nf.shopping.goods_search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author 彭哥
 * @date 2020/3/23
 */
@Document(indexName = "users",type = "_doc")
public class GoodsType {

    @Id
    private String gtId;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String gtName;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String pId;

    public String getGtId() {
        return gtId;
    }

    public void setGtId(String gtId) {
        this.gtId = gtId;
    }

    public String getGtName() {
        return gtName;
    }

    public void setGtName(String gtName) {
        this.gtName = gtName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
}
