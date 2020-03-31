package edu.nf.shopping.warehouse.service;

import edu.nf.shopping.warehouse.entity.CargoInfo;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/31
 */
public interface CargoInfoService {
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
     * 修改货物信息
     */
    void updateCargoInfo();
}
