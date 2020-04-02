package edu.nf.shopping.logistics.service.impl;

import edu.nf.shopping.logistics.service.CityService;
import edu.nf.shopping.logistics.dao.CityDao;
import edu.nf.shopping.logistics.entity.City;
import edu.nf.shopping.logistics.entity.ReturnCityMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lishun
 * @date 2020/4/2
 */
@Service("cityService")
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao dao;
    @Override
    public ReturnCityMap getCityMap() {
        ReturnCityMap returnCityMap = new ReturnCityMap();
        Map<String, List<City>> listMapProvince = new HashMap<>();
        Map<String,List<City>> listMapCity = new HashMap<>();

        List<City> listProvince = dao.getProvince();
        for (City Province : listProvince) {
            List<City> listCity = dao.getCity(Province.getCid());
            listMapProvince.put(Province.getCname(),listCity);
            for (City city : listCity) {
                List<City> listArea = dao.getArea(city.getCid());
                listMapCity.put(city.getCname(),listArea);
            }
        }
        returnCityMap.setListMapProvince(listMapProvince);
        returnCityMap.setListMapCity(listMapCity);
        return returnCityMap;
    }
}
