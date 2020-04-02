package edu.nf.shopping.page.service;

import edu.nf.shopping.page.entity.PageRegion;
import edu.nf.shopping.page.entity.RegionContent;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/27
 */
public interface RegionContentService {

    void updateRegionContent(List<RegionContent> regionContent);

    void updateRegionImage(MultipartFile file,String link,String prId ,String index);

}