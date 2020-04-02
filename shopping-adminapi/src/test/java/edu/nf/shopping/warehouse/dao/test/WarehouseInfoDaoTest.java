package edu.nf.shopping.warehouse.dao.test;

import edu.nf.shopping.warehouse.dao.WarehouseInfoDao;
import edu.nf.shopping.warehouse.entity.WarehouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.UUID;


/**
 * @author lishun
 * @date 2020/3/12
 */
@SpringBootTest
public class WarehouseInfoDaoTest {
    @Autowired
    private WarehouseInfoDao dao;
    @Test
    public void listWarehouse(){
        List<WarehouseInfo> warehouseInfoList = dao.listWarehouse();
        for (WarehouseInfo warehouseInfo : warehouseInfoList) {
            System.out.println(warehouseInfo.getWarehouseName());
        }
    }
    @Test
    public void listWarehouseCity(){
        String cityname = "珠海%";
        List<WarehouseInfo> warehouseInfoList = dao.getWarehouseByCitys(cityname);
        for (WarehouseInfo warehouseInfo : warehouseInfoList) {
            System.out.println(warehouseInfo.getWarehouseName());
        }
    }

    @Test
    public void updateWarehouseByCityName(){
        WarehouseInfo warehouseInfo = new WarehouseInfo();
        warehouseInfo.setWid("8dcc3308b9e944708e185953087113c0");
        warehouseInfo.setWarehouseName("南昌的仓库");
        warehouseInfo.setWarehouseAdmin("李四");
        warehouseInfo.setWarehouseAddress("南昌");
        warehouseInfo.setWarehouseRegion(233);
         dao.updateWarehouseById(warehouseInfo);

    }
    @Test
    public void insertWarehouse(){
        WarehouseInfo warehouseInfo = new WarehouseInfo();
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        warehouseInfo.setWid(uuid);
        warehouseInfo.setWarehouseName("南昌仓库");
        warehouseInfo.setWarehouseAdmin("李四");
        warehouseInfo.setWarehouseAddress("南昌");
        warehouseInfo.setWarehouseRegion(233);
        dao.insertWarehouse(warehouseInfo);

    }
}
