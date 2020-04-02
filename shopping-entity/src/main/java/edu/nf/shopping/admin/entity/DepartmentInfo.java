package edu.nf.shopping.admin.entity;

import edu.nf.shopping.warehouse.entity.City;

/**
 * @author Achine
 * @date 2020/4/2
 */
public class DepartmentInfo {
    private Integer dpmentId;
    private String dpmentName;
    private String dpmentRemark;
    private City dpmentRegion;
    private String dpmentAddress;
    private String dpmentTel;

    public Integer getDpmentId() {
        return dpmentId;
    }

    public void setDpmentId(Integer dpmentId) {
        this.dpmentId = dpmentId;
    }

    public String getDpmentName() {
        return dpmentName;
    }

    public void setDpmentName(String dpmentName) {
        this.dpmentName = dpmentName;
    }

    public String getDpmentRemark() {
        return dpmentRemark;
    }

    public void setDpmentRemark(String dpmentRemark) {
        this.dpmentRemark = dpmentRemark;
    }

    public City getDpmentRegion() {
        return dpmentRegion;
    }

    public void setDpmentRegion(City dpmentRegion) {
        this.dpmentRegion = dpmentRegion;
    }

    public String getDpmentAddress() {
        return dpmentAddress;
    }

    public void setDpmentAddress(String dpmentAddress) {
        this.dpmentAddress = dpmentAddress;
    }

    public String getDpmentTel() {
        return dpmentTel;
    }

    public void setDpmentTel(String dpmentTel) {
        this.dpmentTel = dpmentTel;
    }
}
