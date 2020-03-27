package edu.nf.shopping.warehouse.dao.test;

import edu.nf.shopping.warehouse.dao.SupplierInfoDao;
import edu.nf.shopping.warehouse.entity.SupplierInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/14
 */
@SpringBootTest
public class SupplierInfoDaoTest {
    @Autowired
    private SupplierInfoDao dao;
    @Test
    public void listSupplierInfo(){
        List<SupplierInfo > supplierInfos = dao.listSupplierInfo();
        for (SupplierInfo supplierInfo : supplierInfos) {
            System.out.println(supplierInfo.getSupplierName());
        }
    }
    @Test
    public void insertSupplierInfo(){
        SupplierInfo supplierInfo = new SupplierInfo();
        supplierInfo.setSupplierName("李杰峰的童鞋厂");
        supplierInfo.setSupplierTel("12345678901");
        supplierInfo.setSupplierAddress("珠海市斗门区南方鞋厂");
        dao.insertSupplierInfo(supplierInfo);
    }
    @Test
    public  void deleteSupplier(){
        Integer id = 2;
        dao.deleteSupplierInfo(id);
    }
    @Test
    public void updateSupplier(){
        SupplierInfo supplierInfo = new SupplierInfo();
        supplierInfo.setSupplierId(2);
        supplierInfo.setSupplierName("李杰峰的造童鞋厂");
        supplierInfo.setSupplierTel("12345678901");
        supplierInfo.setSupplierAddress("珠海市斗门区南方鞋厂");
        dao.updateSupplierInfoByid(supplierInfo);
    }
}
