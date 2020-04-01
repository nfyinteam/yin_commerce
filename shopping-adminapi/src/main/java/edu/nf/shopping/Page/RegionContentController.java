package edu.nf.shopping.Page;

import edu.nf.shopping.page.entity.RegionContent;
import edu.nf.shopping.page.service.RegionContentService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "修改内容", notes = "修改区域的内容", httpMethod = "post")
    @ApiImplicitParam(name = "infoList",value = "内容信息",required = true)
    private ResponseVO updateHomePage(@RequestBody List<RegionContent> infoList) throws IOException {
        contentService.updateRegionContent(infoList);
        return success(200,"");
    }

    @RequestMapping(value="update_editImage",headers = "content-type=multipart/*")
    @ApiOperation(value = "修改内容图片", notes = "修改区域的内容图片", httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam( name = "prId",value = "区域编号",required = true),
            @ApiImplicitParam( name = "index",value = "图片顺序",required = true),
            @ApiImplicitParam( name = "link",value = "图片链接",required = true),
            @ApiImplicitParam( name = "file",value = "图片文件",required = true),
    })
    private ResponseVO updateHomePage(String prId,String index,String link,@RequestParam("file") MultipartFile file) throws IOException {
        contentService.updateRegionImage(file,link,prId,index);
        return success(200,"");
    }
}