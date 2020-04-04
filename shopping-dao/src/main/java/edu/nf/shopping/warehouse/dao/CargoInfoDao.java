package edu.nf.shopping.warehouse.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.nf.shopping.warehouse.entity.CargoInfo;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/11
 */
public interface CargoInfoDao {
    /**
     *查询所有货物信息
     * @return
     */
    List<CargoInfo> listCargoInfo();

    /**
     * 添加货物信息
     * @param cargoInfo
     */
    void insertCargoInfo(CargoInfo cargoInfo);

    /**
     * 删除货物
     * @param cargoId
     */
    void deleteCargoInfo(String cargoId);

    /**
     * 获取商品信息
     * @param cargoId
     * @return
     */
    CargoInfo getCargoInfoById(String cargoId);
    /**
     * 修改货物信息
     */
    void updateCargoInfo(CargoInfo cargoInfo);

    /**
     * 获取货物id给支付
     * @param skuid
     * @return
     */
    String getCargoIdBySkuId(String skuid);

    /**
     * 修改货物出库信息
     * @param cargoId
     */
    void updateCargoALibrary(String cargoId);
    /**
     * 修改货物入库信息
     * @param cargoId
     */
    void updateCargoWarehousing(String cargoId);
}
