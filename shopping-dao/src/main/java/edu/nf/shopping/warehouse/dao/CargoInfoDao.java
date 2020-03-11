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
     * 返回所有货物信息表
     * @return
     */
    List<CargoInfo> listCargoInfo();

    /**
     * 返回单个
     * @param id
     * @return
     */
    CargoInfo getCargoInfoById(String id);

    /**
     * 修改货物是否出货
     * @param id
     * @param isOut
     */
    void updateCargoIsOutById(String id,Boolean isOut);

}
