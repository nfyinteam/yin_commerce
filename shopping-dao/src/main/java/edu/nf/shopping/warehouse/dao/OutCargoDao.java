package edu.nf.shopping.warehouse.dao;

import edu.nf.shopping.warehouse.entity.CargoInfo;
import edu.nf.shopping.warehouse.entity.OutCargo;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/17
 */
public interface OutCargoDao {
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

    /**
     * 添加出库信息
     * @param outCargo
     */
    void insertOutCargo(OutCargo outCargo);
}
