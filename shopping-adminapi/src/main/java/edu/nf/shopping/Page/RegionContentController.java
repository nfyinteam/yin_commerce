package edu.nf.shopping.Page;

import edu.nf.shopping.page.entity.RegionContent;
import edu.nf.shopping.page.service.RegionContentService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/28
 */
@RestController
public class RegionContentController extends BaseController {

    @Autowired
    private RegionContentService contentService;

    @RequestMapping(value="update_editInfo")
    private ResponseVO updateHomePage(@RequestBody List<RegionContent> infoList, HttpServletRequest request) throws IOException {
        contentService.updateRegionContent(infoList);
        return success(200,"");
    }

    @RequestMapping(value="update_editImage",headers = "content-type=multipart/*")
    private ResponseVO updateHomePage(String prId,String index,String link,@RequestParam("file") MultipartFile file) throws IOException {
        contentService.updateRegionImage(file,link,prId,index);
        return success(200,"");
    }
}