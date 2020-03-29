package edu.nf.shopping.Page;

import com.alibaba.fastjson.JSONObject;
import edu.nf.shopping.page.entity.PageRegion;
import edu.nf.shopping.page.entity.RegionContent;
import edu.nf.shopping.page.service.PageRegionService;
import edu.nf.shopping.util.FileNameUtils;
import edu.nf.shopping.util.UUIDUtils;
import edu.nf.shopping.util.UploadAddressUtils;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.RegionVO;
import edu.nf.shopping.vo.ResponseVO;
import edu.nf.shopping.warehouse.entity.RegionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/26
 */
@RestController
public class PageRegionController extends BaseController {

    @Autowired
    private PageRegionService pageRegionService;

    @RequestMapping("/add_pageRegion")
    private ResponseVO updateHomePage(String regionSign,String index,String editNumber) {
        PageRegion pageRegion=pageRegionService.addPageRegion(regionSign,index,editNumber,"0");
        return success(pageRegion);
    }

    @RequestMapping("/list_pageRegion")
    private ResponseVO listHomePage() {
        List<PageRegion> list=pageRegionService.listPageRegion(new String[]{"0"});
        return success(list);
    }

    @RequestMapping("/update_pageRegion")
    private ResponseVO updatePageRegion(@RequestBody List<PageRegion> regionList) {
        pageRegionService.updatePageRegion(regionList);
        return success(200,"");
    }

    @RequestMapping("/submit_pageRegion")
    private ResponseVO submitPageRegion(@RequestBody List<PageRegion> regionList) {
        pageRegionService.submitPageRegion(regionList);
        return success(200,"提交成功");
    }

    @RequestMapping("/delete_pageRegionByState")
    private ResponseVO deletePageRegionByState(@RequestBody List<PageRegion> regionList) {
        pageRegionService.deletePageRegionByState(regionList,new String[]{"0","2"});
        return success(200,"");
    }
}