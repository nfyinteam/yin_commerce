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
     * 查询所有仓库所在城市
     * @return
     */
    List<String> listWarehouseCity();

    /**
     * 按照城市查找仓库
     * @param cityName
     * @return
     */
    List<WarehouseInfo> getWarehouseByCitys(String cityName);

    /**
     * 修改仓库信息
     * @param cityName
     */
    void updateWarehouseByCityName(String cityName);

    /**
     * 用ID查找仓库
     * @param warehouseId
     * @return
     */
    WarehouseInfo getWarehouseById(String warehouseId);


}
