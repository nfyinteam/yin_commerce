package edu.nf.shopping.warehouse.service.impl;

import edu.nf.shopping.warehouse.dao.CargoInfoDao;
import edu.nf.shopping.warehouse.entity.CargoInfo;
import edu.nf.shopping.warehouse.exception.WarehouseException;
import edu.nf.shopping.warehouse.service.CargoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/31
 */
@Service
public class CargoInfoServiceImpl implements CargoInfoService {
    @Autowired
    private CargoInfoDao dao;
    @Override
    public List<CargoInfo> listCargoInfo() {
        try {
            return dao.listCargoInfo();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new WarehouseException("数据库出错");
        }
    }

    @Override
    public void insertCargoInfo(CargoInfo cargoInfo) {
        try {
            dao.insertCargoInfo(cargoInfo);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new WarehouseException("数据库出错");
        }
    }

    @Override
    public void deleteCargoInfo(String cargoId) {
        try {
            dao.deleteCargoInfo(cargoId);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new WarehouseException("数据库出错");
        }
    }

    @Override
    public void updateCargoInfo() {
        try {
            dao.updateCargoInfo();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new WarehouseException("数据库出错");
        }
    }
}
