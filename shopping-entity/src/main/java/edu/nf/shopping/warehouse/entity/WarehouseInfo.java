package edu.nf.shopping.warehouse.entity;

/**
 * @author lishun
 * @date 2020/3/11
 * 仓库信息表
 */
public class WarehouseInfo {
    /**
     * 仓库编号主键
     */
    private  String wid;
    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 关联城市编号
     */
    private Integer warehouseRegion;
    /**
     * 仓库详细地址
     */
    private String warehouseAddress;
    /**
     * 仓库负责人
     */
    private String warehouseAdmin;
    /**
     * 仓库地址
     */
    private City city;

    public WarehouseInfo(String wid, String warehouseName, Integer warehouseRegion, String warehouseAddress, String warehouseAdmin, City city) {
        this.wid = wid;
        this.warehouseName = warehouseName;
        this.warehouseRegion = warehouseRegion;
        this.warehouseAddress = warehouseAddress;
        this.warehouseAdmin = warehouseAdmin;
        this.city = city;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getWarehouseRegion() {
        return warehouseRegion;
    }

    public void setWarehouseRegion(Integer warehouseRegion) {
        this.warehouseRegion = warehouseRegion;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehouseAdmin() {
        return warehouseAdmin;
    }

    public void setWarehouseAdmin(String warehouseAdmin) {
        this.warehouseAdmin = warehouseAdmin;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public WarehouseInfo() {
    }
}
