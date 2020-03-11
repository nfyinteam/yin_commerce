package edu.nf.shopping.warehouse.entity;

/**
 * @author lishun
 * @date 2020/3/11
 * 区域类型表
 */
public class RegionType {
    /**
     * 区域类型编号；主键
     */
    private Integer rtId;
    /**
     * 区域类型名称
     */
    private  String rtName;

    public RegionType() {
    }

    public Integer getRtId() {
        return rtId;
    }

    public void setRtId(Integer rtId) {
        this.rtId = rtId;
    }

    public String getRtName() {
        return rtName;
    }

    public void setRtName(String rtName) {
        this.rtName = rtName;
    }

    public RegionType(Integer rtId, String rtName) {
        this.rtId = rtId;
        this.rtName = rtName;
    }
}
