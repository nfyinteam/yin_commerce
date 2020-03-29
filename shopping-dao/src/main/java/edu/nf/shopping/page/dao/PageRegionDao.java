package edu.nf.shopping.page.dao;

import edu.nf.shopping.page.entity.PageRegion;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/27
 */
public interface PageRegionDao {

    List<PageRegion> listPageRegion(String[] states);

    void addPageRegion(PageRegion pageRegion);

    void updatePageRegionIndex(List<PageRegion> list);

    void updatePageRegionState(String prId);

    void submitPageRegion(List<PageRegion> list);

    void deletePageRegionByState(String prId,String[] state);

}