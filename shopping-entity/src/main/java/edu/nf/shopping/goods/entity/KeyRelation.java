package edu.nf.shopping.goods.entity;

/**
 * @author Achine
 * @date 2020/2/27
 */
public class KeyRelation {
    private KeyInfo key;
    private ValueInfo value;
    private GoodsInfo good;

    public KeyInfo getKey() {
        return key;
    }

    public void setKey(KeyInfo key) {
        this.key = key;
    }

    public ValueInfo getValue() {
        return value;
    }

    public void setValue(ValueInfo value) {
        this.value = value;
    }

    public GoodsInfo getGood() {
        return good;
    }

    public void setGood(GoodsInfo good) {
        this.good = good;
    }
}
