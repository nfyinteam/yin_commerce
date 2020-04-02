package edu.nf.shopping.logistics.dao;

import edu.nf.shopping.logistics.entity.City;

import java.util.List;

/**
 * @author lishun
 * @date 2020/4/2
 */
public interface CityDao {
    /**
     * 获取省份
     * @return
     */
    List<City> getProvince();

    /**
     * 获取城市
     * @param pid
     * @return
     */
    List<City> getCity(Integer pid);

    /**
     * 获取区
     * @param pid
     * @return
     */
    List<City> getArea(Integer pid);
}
