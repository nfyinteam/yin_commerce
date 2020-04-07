package edu.nf.shopping.page.service;

import edu.nf.shopping.page.entity.PageRegion;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/27
 */
public interface PageRegionService {

    List<PageRegion> listPageRegion(String[] state);

    PageRegion addPageRegion(String regionSign,String index,String editNumber,String state);

    void updatePageRegion(List<PageRegion> list);

    void submitPageRegion(List<PageRegion> list);

    void deletePageRegionByState(List<PageRegion> pageRegions,String[] state);


}