package edu.nf.shopping.warehouse.dao;

import edu.nf.shopping.warehouse.entity.WarehouseInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/12
 */
@SpringBootTest
public class WarehouseDaoTest {
    @Autowired
    private WarehouseInfoDao dao;
    @Test
    public void listWarehouse(){
        List<WarehouseInfo> warehouseInfoList = dao.listWarehouse();
        for (WarehouseInfo warehouseInfo : warehouseInfoList) {
            System.out.println(warehouseInfo.getWarehouseName());
        }
    }
}
