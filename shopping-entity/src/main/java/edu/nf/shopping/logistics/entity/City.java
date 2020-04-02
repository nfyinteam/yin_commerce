package edu.nf.shopping.logistics.entity;

import java.util.List;
import java.util.Map;

/**
 * @author lishun
 * @date 2020/4/2
 */
public class City {
    private Integer cid;
    private Integer pid;
    private String cname;
    private Integer type;

    public City(Integer cid, Integer pid, String cname, Integer type) {
        this.cid = cid;
        this.pid = pid;
        this.cname = cname;
        this.type = type;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public City() {
    }
}
