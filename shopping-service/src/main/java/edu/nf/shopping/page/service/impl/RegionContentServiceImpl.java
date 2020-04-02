package edu.nf.shopping.page.service.impl;

import edu.nf.shopping.page.dao.RegionContentDao;
import edu.nf.shopping.page.entity.PageRegion;
import edu.nf.shopping.page.entity.RegionContent;
import edu.nf.shopping.page.exception.PageException;
import edu.nf.shopping.page.service.RegionContentService;
import edu.nf.shopping.util.FileNameUtils;
import edu.nf.shopping.util.UUIDUtils;
import edu.nf.shopping.util.UploadAddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/27
 */
@Service("regionInfoService")
@Transactional(rollbackFor = RuntimeException.class)
public class RegionContentServiceImpl implements RegionContentService {

    @Autowired
    private RegionContentDao contentDao;

    @Override
    public void updateRegionContent(List<RegionContent> regionContent) {
        try{
            for (RegionContent content : regionContent) {
                if (content.getInfo().length()<=200){
                    contentDao.updateRegionContent(regionContent);
                }else {
                    throw new PageException("内容长度过长");
                }
            }
        }catch (PageException e){
            throw e;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new PageException("出错了!");
        }
    }

    @Override
    public void updateRegionImage(MultipartFile file,String link, String prId, String index) {
        try{
            List<RegionContent> list=new ArrayList<>();
            String imageName=UUIDUtils.createUUID()+".png";
            RegionContent content1=new RegionContent();
            content1.setState("0");
            content1.setPrId(prId);
            content1.setInfo(imageName);
            content1.setIndex(Integer.parseInt(index)+1);
            list.add(content1);
            RegionContent content2=new RegionContent();
            content2.setState("0");
            content2.setPrId(prId);
            content2.setInfo(link);
            content2.setIndex(Integer.parseInt(index));
            list.add(content2);
            contentDao.updateRegionContent(list);
            FileNameUtils.upload(UploadAddressUtils.PAGE_IMAGES,file.getInputStream(),imageName);
        }catch (RuntimeException | IOException e){
            e.printStackTrace();
            throw new PageException("或许图片太大了");
        }
    }
}