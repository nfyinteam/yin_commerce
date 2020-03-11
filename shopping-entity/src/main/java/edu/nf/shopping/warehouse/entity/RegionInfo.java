package edu.nf.shopping.warehouse.entity;

/**
 * @author lishun
 * @date 2020/3/11
 * 区域信息表
 */
public class RegionInfo {
    /**
     * 区域编号，主键自动增长
     */
    private Integer rid;
    /**
     * 区域名称
     */
    private String regionName;
    /**
     * 区域类型编号
     */
    private Integer rtId;
    /**
     * 父级区域编号
     */
    private Integer pid;
    /**
     * 仓库编号
     */
    private Integer warehouseId;
    /**
     * 一对一关系
     */
    private RegionInfo regionInfo;

    public RegionInfo(Integer rid, String regionName, Integer rtId, Integer pid, Integer warehouseId, RegionInfo regionInfo) {
        this.rid = rid;
        this.regionName = regionName;
        this.rtId = rtId;
        this.pid = pid;
        this.warehouseId = warehouseId;
        this.regionInfo = regionInfo;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getRtId() {
        return rtId;
    }

    public void setRtId(Integer rtId) {
        this.rtId = rtId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public RegionInfo getRegionInfo() {
        return regionInfo;
    }

    public void setRegionInfo(RegionInfo regionInfo) {
        this.regionInfo = regionInfo;
    }

    public RegionInfo() {
    }
}
