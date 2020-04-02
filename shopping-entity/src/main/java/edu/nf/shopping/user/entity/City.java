package edu.nf.shopping.user.entity;

/**
 * @author Vera
 * @date 2020/4/1
 */
public class City {
    private Integer cid;
    private Integer pid;
    private String cname;
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
}
