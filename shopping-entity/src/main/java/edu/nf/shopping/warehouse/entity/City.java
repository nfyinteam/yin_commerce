package edu.nf.shopping.warehouse.entity;

/**
 * @author lishun
 * @date 2020/3/11
 * 城市信息表
 */
public class City {
    /**
     * 主键编号
     */
    private Integer cid;
    /**
     * 父级城市编号
     */
    private Integer pid;
    /**
     * 城市名称
     */
    private String  cname;
    /**
     * 类型编号
     */
    private Integer type;

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

    public City(Integer cid, Integer pid, String cname, Integer type) {
        this.cid = cid;
        this.pid = pid;
        this.cname = cname;
        this.type = type;
    }

    public City() {
    }
}
