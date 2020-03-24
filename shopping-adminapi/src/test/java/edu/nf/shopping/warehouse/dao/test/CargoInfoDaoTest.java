package edu.nf.shopping.warehouse.dao.test;

import edu.nf.shopping.goods.entity.GoodsInfo;
import edu.nf.shopping.warehouse.dao.CargoInfoDao;
import edu.nf.shopping.warehouse.entity.CargoInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lishun
 * @date 2020/3/16
 */
@SpringBootTest
public class CargoInfoDaoTest {
    @Autowired
    private CargoInfoDao dao;
    @Test
    public void insertCargoInfoTest() throws ParseException {
        CargoInfo cargoInfo = new CargoInfo();
          long  timeNew =  System.currentTimeMillis(); // 13位数的时间戳
        String time = String.valueOf(timeNew);
        cargoInfo.setCargoId(time);
        cargoInfo.setSkuId("1577706998509");
        cargoInfo.setRid(1);
        cargoInfo.setPid("1");
        cargoInfo.setSupplierId(3);

        cargoInfo.setPutPrice(new BigDecimal(10000));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        Date t = new Date();
        t= sdf.parse(sdf.format(new Date()));
        cargoInfo.setPutTime(t);
        cargoInfo.setPutAdmin("李顺");

        cargoInfo.setOut(false);
        cargoInfo.setItemNo("1234567890");

        dao.insertCargoInfo(cargoInfo);
    }
    @Test
    public void listCargoInfoTest() {
        List<CargoInfo> list = dao.listCargoInfo();
        for (CargoInfo cargoInfo : list) {
            for (GoodsInfo goodsInfo : cargoInfo.getGoodsInfos()) {
                System.out.println(goodsInfo.getGoodsName());
            }
        }
    }
}
