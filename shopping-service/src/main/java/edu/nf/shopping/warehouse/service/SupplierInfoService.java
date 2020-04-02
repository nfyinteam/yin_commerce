package edu.nf.shopping.warehouse.service;

import edu.nf.shopping.warehouse.entity.SupplierInfo;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/31
 */
public interface SupplierInfoService {
    /**
     * 搜索所有供应商
     * @return
     */
    List<SupplierInfo> listSupplierInfo();

    /**
     * 添加供应商
     */
    void insertSupplierInfo(SupplierInfo supplierInfo);

    /**
     * 修改供应商
     */
    void updateSupplierInfoByid(SupplierInfo supplierInfo);

    /**
     * 删除供应商
     */
    void deleteSupplierInfo(Integer id);

    /**
     * 查询供应商商品
     * @return
     */
    List<SupplierInfo> listSupplierGoodsById();
}
