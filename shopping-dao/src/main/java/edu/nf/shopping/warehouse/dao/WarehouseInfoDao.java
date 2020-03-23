package edu.nf.shopping.warehouse.dao;

import edu.nf.shopping.warehouse.entity.WarehouseInfo;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/12
 */
public interface WarehouseInfoDao {
    /**
     * 查询所有仓库
     * @return
     */
    List<WarehouseInfo> listWarehouse();



    /**
     * 按照城市查找仓库
     * @param cityName
     * @return
     */
    List<WarehouseInfo> getWarehouseByCitys(String cityName);

    void updateWarehouseById(WarehouseInfo warehouseInfo);
    /**
     * 用ID查找仓库
     * @param warehouseId
     * @return
     */
    WarehouseInfo getWarehouseById(String warehouseId);

    /**
     * 添加仓库
     * @param warehouseInfo
     */
    void insertWarehouse(WarehouseInfo warehouseInfo);

}
