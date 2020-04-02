package edu.nf.shopping.logistics.service;

import edu.nf.shopping.logistics.entity.City;
import edu.nf.shopping.logistics.entity.ReturnCityMap;

import java.util.List;
import java.util.Map;

/**
 * @author lishun
 * @date 2020/4/2
 */
public interface CityService {
    /**
     * 获取省下城市
     * @return
     */
    ReturnCityMap getCityMap();
}
