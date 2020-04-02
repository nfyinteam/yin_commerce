package edu.nf.shopping.logistics.entity;

import java.util.List;
import java.util.Map;

/**
 * @author lishun
 * @date 2020/4/2
 */
public class ReturnCityMap {
    Map<String, List<City>> listMapProvince;
    Map<String,List<City>> listMapCity;

    public ReturnCityMap(Map<String, List<City>> listMapProvince, Map<String, List<City>> listMapCity) {
        this.listMapProvince = listMapProvince;
        this.listMapCity = listMapCity;
    }

    public ReturnCityMap() {
    }

    public Map<String, List<City>> getListMapProvince() {
        return listMapProvince;
    }

    public void setListMapProvince(Map<String, List<City>> listMapProvince) {
        this.listMapProvince = listMapProvince;
    }

    public Map<String, List<City>> getListMapCity() {
        return listMapCity;
    }

    public void setListMapCity(Map<String, List<City>> listMapCity) {
        this.listMapCity = listMapCity;
    }
}
