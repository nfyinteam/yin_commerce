package edu.nf.shopping.warehouse.service.impl;

import edu.nf.shopping.util.UUIDUtils;
import edu.nf.shopping.warehouse.dao.CargoInfoDao;
import edu.nf.shopping.warehouse.dao.OutCargoDao;
import edu.nf.shopping.warehouse.entity.CargoInfo;
import edu.nf.shopping.warehouse.entity.OutCargo;
import edu.nf.shopping.warehouse.exception.WarehouseException;
import edu.nf.shopping.warehouse.service.CargoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lishun
 * @date 2020/3/31
 */
@Service("CargoInfoService")
public class CargoInfoServiceImpl implements CargoInfoService {
    @Autowired
    private CargoInfoDao dao;
    @Autowired
    private OutCargoDao OutCargoDao;
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
    public CargoInfo getCargoInfoById(String cargoId) {
        try {
           return  dao.getCargoInfoById(cargoId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("数据库出错");
        }

    }

    @Override
    public void updateCargoALibrary(String cargoId) {
        try {
            dao.updateCargoALibrary(cargoId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("数据库出错");
        }
    }

    @Override
    public void updateCargoWarehousing(String cargoId) {
        try {
            dao.updateCargoALibrary(cargoId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("数据库出错");
        }
    }

    @Override
    public String getCargoIdBySkuId(String skuid) {
        try {
            String cargoId =  dao.getCargoIdBySkuId(skuid);
            return cargoId;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("数据库出错");
        }
    }
    @Override
    public void updateCargoInfo(CargoInfo cargoInfo) {
        try {
            dao.updateCargoInfo( cargoInfo);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new WarehouseException("数据库出错");
        }
    }
}
