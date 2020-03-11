package edu.nf.shopping.warehouse.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lishun
 * @date 2020/3/11
 * 货物信息表
 */
public class CargoInfo {
    /**
     *时间戳 id
     */
    private  String cargoId;
    /**
     * suk编号
     */
    private String skuId;
    /**
     * 外建 区域编号
     */
    private Integer rid;
    /**
     *父级区域编号
     */
    private Integer pid;
    /**
     * 供应商编号
     */
    private Integer supplierId;
    /**
     * 入库价格
     */
    private BigDecimal putPrice;
    /**
     * 入库时间
     */
    private Date putTime;
    /**
     * 入库人员
     */
    private String putAdmin;
    /**
     * 1为出货
     * 0为出货
     */
    private Boolean isOut;
    /**
     * 货号
     */
    private String itemNo;

    private List<RegionInfo> regionInfos;

    public CargoInfo(String cargoId, String skuId, Integer rid, Integer pid, Integer supplierId, BigDecimal putPrice, Date putTime, String putAdmin, Boolean isOut, String itemNo, List<RegionInfo> regionInfos) {
        this.cargoId = cargoId;
        this.skuId = skuId;
        this.rid = rid;
        this.pid = pid;
        this.supplierId = supplierId;
        this.putPrice = putPrice;
        this.putTime = putTime;
        this.putAdmin = putAdmin;
        this.isOut = isOut;
        this.itemNo = itemNo;
        this.regionInfos = regionInfos;
    }

    public String getCargoId() {
        return cargoId;
    }

    public void setCargoId(String cargoId) {
        this.cargoId = cargoId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getPutPrice() {
        return putPrice;
    }

    public void setPutPrice(BigDecimal putPrice) {
        this.putPrice = putPrice;
    }

    public Date getPutTime() {
        return putTime;
    }

    public void setPutTime(Date putTime) {
        this.putTime = putTime;
    }

    public String getPutAdmin() {
        return putAdmin;
    }

    public void setPutAdmin(String putAdmin) {
        this.putAdmin = putAdmin;
    }

    public Boolean getOut() {
        return isOut;
    }

    public void setOut(Boolean out) {
        isOut = out;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public List<RegionInfo> getRegionInfos() {
        return regionInfos;
    }

    public void setRegionInfos(List<RegionInfo> regionInfos) {
        this.regionInfos = regionInfos;
    }

    public CargoInfo() {
    }
}
