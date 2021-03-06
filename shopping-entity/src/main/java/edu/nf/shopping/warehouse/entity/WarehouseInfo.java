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
    private String WarehouseName;
    /**
     * 关联城市编号
     */
    private Integer WarehouseRegion;
    /**
     * 仓库详细地址
     */
    private String WarehouseAddress;
    /**
     * 仓库负责人
     */
    private String WarehouseAdmin;
    /**
     * 仓库地址
     */
    private City city;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getWarehouseName() {
        return WarehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        WarehouseName = warehouseName;
    }

    public Integer getWarehouseRegion() {
        return WarehouseRegion;
    }

    public void setWarehouseRegion(Integer warehouseRegion) {
        WarehouseRegion = warehouseRegion;
    }

    public String getWarehouseAddress() {
        return WarehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        WarehouseAddress = warehouseAddress;
    }

    public String getWarehouseAdmin() {
        return WarehouseAdmin;
    }

    public void setWarehouseAdmin(String warehouseAdmin) {
        WarehouseAdmin = warehouseAdmin;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public WarehouseInfo(String wid, String warehouseName, Integer warehouseRegion, String warehouseAddress, String warehouseAdmin, City city) {
        this.wid = wid;
        WarehouseName = warehouseName;
        WarehouseRegion = warehouseRegion;
        WarehouseAddress = warehouseAddress;
        WarehouseAdmin = warehouseAdmin;
        this.city = city;
    }

    public WarehouseInfo() {
    }
}
