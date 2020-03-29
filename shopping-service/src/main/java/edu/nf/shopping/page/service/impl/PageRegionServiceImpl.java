package edu.nf.shopping.page.service.impl;

import edu.nf.shopping.page.dao.RegionContentDao;
import edu.nf.shopping.page.exception.PageException;
import edu.nf.shopping.page.service.PageRegionService;
import edu.nf.shopping.page.dao.PageRegionDao;
import edu.nf.shopping.page.entity.PageRegion;
import edu.nf.shopping.page.entity.RegionContent;
import edu.nf.shopping.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/27
 */
@Service("pageRegionService")
@Transactional(rollbackFor = RuntimeException.class)
public class PageRegionServiceImpl implements PageRegionService {

    @Autowired
    private PageRegionDao pageRegionDao;

    @Autowired
    private RegionContentDao regionContentDao;

    @Override
    public List<PageRegion> listPageRegion(String[] state) {
        try{
            List<PageRegion> list=pageRegionDao.listPageRegion(state);
            for (PageRegion pageRegion : list) {
                pageRegion.setInfoList(regionContentDao.listRegionInfo(state,pageRegion.getPrId()));
            }
            return list;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new PageException(e.getMessage());
        }
    }

    @Override
    public PageRegion addPageRegion(String regionSign,String index,String editNumber,String state) {
        try{
            PageRegion pageRegion=new PageRegion();
            pageRegion.setPrId(UUIDUtils.createUUID());
            pageRegion.setIndex(index);
            pageRegion.setStartTime(null);
            pageRegion.setSign(regionSign);
            pageRegionDao.addPageRegion(pageRegion);
            //根据内容数量创建
            for(int i=0;i<Integer.parseInt(editNumber);i++){
                RegionContent info=new RegionContent();
                info.setPrId(pageRegion.getPrId());
                info.setInfo("NULL");
                info.setIndex(i);
                pageRegion.getInfoList().add(info);
                regionContentDao.addRegionInfo(info);
            }
            return pageRegion;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new PageException(e.getMessage());
        }
    }

    @Override
    public void updatePageRegion(List<PageRegion> list) {
        try{
            pageRegionDao.updatePageRegionIndex(list);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new PageException(e.getMessage());
        }
    }

    @Override
    public void submitPageRegion(List<PageRegion> list) {
        try{
            //更新区域index和状态
            pageRegionDao.submitPageRegion(list);
            //将待删除的区域删除
            pageRegionDao.deletePageRegionByState(null,new String[]{"3"});
            //查找草稿内容并更新
            for (PageRegion pageRegion : list) {
                List<RegionContent> contents=regionContentDao.listRegionInfo(new String[]{"0"},pageRegion.getPrId());
                regionContentDao.submitRegionContent(contents);
            }//将待删除的内容删除
            regionContentDao.delRegionContent(null,new String[]{"3"});
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new PageException(e.getMessage());
        }
    }

    @Override
    public void deletePageRegionByState(List<PageRegion> pageRegions,String[] state) {
        try{
            if(pageRegions.size()>0){
                for (PageRegion pageRegion : pageRegions) {
                    if("null".equals(pageRegion.getState())){
                        //删除区域草稿
                        pageRegionDao.deletePageRegionByState(pageRegion.getPrId(),state);
                        //修改已显示区域的状态
                        pageRegionDao.updatePageRegionState(pageRegion.getPrId());
                        regionContentDao.delRegionContent(pageRegion.getPrId(),state);
                        regionContentDao.updateRegionContentState(pageRegion.getPrId());
                    }else {
                        //更新区域index
                        pageRegionDao.updatePageRegionIndex(pageRegions);
                    }
                }
            }

        }catch (RuntimeException e){
            e.printStackTrace();
            throw new PageException(e.getMessage());
        }
    }

}