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
<<<<<<< HEAD
     * 返回所有货物信息表
=======
     * 搜索所有
>>>>>>> f65dbfe0523f4b82c994deaa51d9c7a2b718bae3
     * @return
     */
    List<CargoInfo> listCargoInfo();

    /**
<<<<<<< HEAD
     * 返回单个
=======
     *
>>>>>>> f65dbfe0523f4b82c994deaa51d9c7a2b718bae3
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
