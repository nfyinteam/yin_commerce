package edu.nf.shopping.warehouse.impl;

import edu.nf.shopping.warehouse.WarehouseInfoService;
import edu.nf.shopping.warehouse.entity.WarehouseInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/14
 */
public class WarehouseInfoServiceImpl implements WarehouseInfoService {
    @Autowired
    private WarehouseInfoService service;
    @Override
    public List<WarehouseInfo> listWarehouse() {
        return service.listWarehouse();
    }

    @Override
    public List<WarehouseInfo> getWarehouseByCitys(String cityName) {
        return  service.getWarehouseByCitys(cityName);
    }

    @Override
    public void updateWarehouseById(WarehouseInfo warehouseInfo) {
       service.updateWarehouseById(warehouseInfo);
    }

    @Override
    public WarehouseInfo getWarehouseById(String warehouseId) {
        return service.getWarehouseById(warehouseId);
    }

    @Override
    public void insertWarehouse(WarehouseInfo warehouseInfo) {
         service.insertWarehouse(warehouseInfo);
    }
}
