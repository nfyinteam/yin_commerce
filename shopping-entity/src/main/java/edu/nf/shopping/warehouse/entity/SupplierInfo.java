package edu.nf.shopping.warehouse.entity;

/**
 * @author lishun
 * @date 2020/3/11
 *供应商信息表
 */
public class SupplierInfo {
    /**
     * 供应商id
     */
    private Integer supplierId;
    /**
     * 供应商名字
     */
    private String supplierName;
    /**
     * 供应商电话
     */
    private String supplierTel;
    /**
     * 供应商地址
     */
    private String supplierAddress;


    public SupplierInfo(Integer supplierId, String supplierName, String supplierTel, String supplierAddress) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierTel = supplierTel;
        this.supplierAddress = supplierAddress;
    }

    public SupplierInfo() {
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierTel() {
        return supplierTel;
    }

    public void setSupplierTel(String supplierTel) {
        this.supplierTel = supplierTel;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }
}
