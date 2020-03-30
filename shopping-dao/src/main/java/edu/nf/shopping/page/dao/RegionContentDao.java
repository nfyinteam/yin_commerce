package edu.nf.shopping.page.dao;

import edu.nf.shopping.page.entity.PageRegion;
import edu.nf.shopping.page.entity.RegionContent;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/27
 */
public interface RegionContentDao {

    List<RegionContent> listRegionInfo(String[] states,String prId);

    void addRegionInfo(RegionContent regionContent);

    void updateRegionContent(List<RegionContent> regionContent);

    void updateRegionContentState(String prId);

    void submitRegionContent(List<RegionContent> contents);

    void delRegionContent(String prId,String[] state);
}