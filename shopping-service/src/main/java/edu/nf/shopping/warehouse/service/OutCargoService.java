package edu.nf.shopping.warehouse.service;

import edu.nf.shopping.warehouse.entity.CargoInfo;
import edu.nf.shopping.warehouse.entity.OutCargo;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/31
 */
public interface OutCargoService {
    /**
     * 搜素所有出卖订单
     * @return
     */
    List<OutCargo> listOutCargo();

    /**
     * 用id搜索
     * @param id
     * @return
     */
    OutCargo getOutCargoById(String id);

    /**
     * 修改状态
     * @param cargoInfo
     */
    void updateOutCargo(CargoInfo cargoInfo);
}
