package edu.nf.shopping.warehouse.service.impl;

import edu.nf.shopping.warehouse.dao.SupplierInfoDao;
import edu.nf.shopping.warehouse.entity.SupplierInfo;
import edu.nf.shopping.warehouse.exception.WarehouseException;
import edu.nf.shopping.warehouse.service.SupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/31
 */
@Service("SupplierInfoService")
public class SupplierInfoServiceImpl  implements SupplierInfoService {
    @Autowired
    private SupplierInfoDao dao;
    @Override
    public List<SupplierInfo> listSupplierInfo() {
        try {
            return dao.listSupplierInfo();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }

    }

    @Override
    public void insertSupplierInfo(SupplierInfo supplierInfo) {
        try {
            dao.insertSupplierInfo(supplierInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }

    @Override
    public void updateSupplierInfoByid(SupplierInfo supplierInfo) {
        try {
            dao.updateSupplierInfoByid(supplierInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }

    @Override
    public void deleteSupplierInfo(Integer id) {
        try {
            dao.deleteSupplierInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }

    @Override
    public List<SupplierInfo> listSupplierGoodsById(Integer id) {
        try {
            return dao.listSupplierGoodsById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
}
