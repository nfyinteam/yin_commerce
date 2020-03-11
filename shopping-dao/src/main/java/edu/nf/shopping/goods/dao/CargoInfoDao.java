package edu.nf.shopping.goods.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.nf.shopping.warehouse.entity.CargoInfo;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/11
 */
public interface CargoInfoDao {
    List<CargoInfo> listCargoInfo();
    CargoInfo getCargoInfoById(String id);
    void updateCargoIsOutById(String id,Boolean isOut);

}
