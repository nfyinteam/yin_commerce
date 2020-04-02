package edu.nf.shopping.warehouse.service.impl;

import edu.nf.shopping.warehouse.dao.WarehouseInfoDao;
import edu.nf.shopping.warehouse.entity.WarehouseInfo;
import edu.nf.shopping.warehouse.exception.WarehouseException;
import edu.nf.shopping.warehouse.service.WarehouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/31
 */
@Service("WarehouseInfoService")
public class WarehouseInfoServiceImpl implements WarehouseInfoService {
    @Autowired
  private   WarehouseInfoDao warehouseInfoDao;
    @Override
    public List<WarehouseInfo> listWarehouse() {
        try {
            return warehouseInfoDao.listWarehouse();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }

    @Override
    public List<WarehouseInfo> getWarehouseByCitys(String cityName) {
        try {
            return warehouseInfoDao.getWarehouseByCitys(cityName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }

    @Override
    public void updateWarehouseById(WarehouseInfo warehouseInfo) {
        try {
            warehouseInfoDao.updateWarehouseById(warehouseInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");

        }
    }

    @Override
    public WarehouseInfo getWarehouseById(String warehouseId) {
        try {
            return warehouseInfoDao.getWarehouseById(warehouseId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");

        }
    }

    @Override
    public void insertWarehouse(WarehouseInfo warehouseInfo) {
        try {
            warehouseInfoDao.insertWarehouse(warehouseInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");

        }
    }
}
