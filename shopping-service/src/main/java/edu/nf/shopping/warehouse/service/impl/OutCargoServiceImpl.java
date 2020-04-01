package edu.nf.shopping.warehouse.service.impl;

import edu.nf.shopping.util.UUIDUtils;
import edu.nf.shopping.warehouse.dao.OutCargoDao;
import edu.nf.shopping.warehouse.entity.CargoInfo;
import edu.nf.shopping.warehouse.entity.OutCargo;
import edu.nf.shopping.warehouse.exception.WarehouseException;
import edu.nf.shopping.warehouse.service.OutCargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/31
 */
@Service("OutCargoService")
public class OutCargoServiceImpl implements OutCargoService {
    @Autowired
    private OutCargoDao dao;
    @Override
    public List<OutCargo> listOutCargo() {
        return null;
    }

    @Override
    public OutCargo getOutCargoById(String id) {
        return null;
    }

    @Override
    public void insertOutCargo(OutCargo outCargo) {
        try {
            dao.insertOutCargo(outCargo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("数据库错误");
        }
    }

    @Override
    public void updateOutCargo(CargoInfo cargoInfo) {

    }
}
