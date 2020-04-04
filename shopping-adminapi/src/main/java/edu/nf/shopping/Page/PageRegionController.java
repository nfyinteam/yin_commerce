package edu.nf.shopping.page;

import edu.nf.shopping.page.entity.PageRegion;
import edu.nf.shopping.page.service.PageRegionService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/26
 */
@RestController
public class PageRegionController extends BaseController {

    @Autowired
    private PageRegionService pageRegionService;

    @RequestMapping("/add_pageRegion/{regionSign}/{index}/{editNumber}")
    @ApiOperation(value = "添加区域", notes = "添加新的区域",
            httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionSign", value = "区域标识", required = true),
            @ApiImplicitParam(name = "index", value = "区域顺序", required = true),
            @ApiImplicitParam(name = "editNumber", value = "区域内容数量", required = true)
    })
    private ResponseVO addPageRegion(@PathVariable("regionSign") String regionSign,@PathVariable("index") String index,@PathVariable("editNumber") String editNumber) {
        PageRegion pageRegion=pageRegionService.addPageRegion(regionSign,index,editNumber,"0");
        return success(pageRegion);
    }

    @RequestMapping("/list_pageRegion")
    @ApiOperation(value = "加载区域", notes = "查询所有区域",
            httpMethod = "get")
    private ResponseVO listHomePage() {
        List<PageRegion> list=pageRegionService.listPageRegion(new String[]{"0"});
        return success(list);
    }

    @RequestMapping("/update_pageRegion")
    @ApiOperation(value = "修改区域", notes = "区域顺序的修改", httpMethod = "post")
    @ApiImplicitParam(name = "regionList",value = "所有区域信息",required = true)
    private ResponseVO updatePageRegion(@RequestBody List<PageRegion> regionList) {
        pageRegionService.updatePageRegion(regionList);
        return success(200,"");
    }

    @RequestMapping("/submit_pageRegion")
    @ApiOperation(value = "提交区域", notes = "把修改完的区域更新", httpMethod = "post")
    @ApiImplicitParam(name = "regionList",value = "所有区域信息",required = true)
    private ResponseVO submitPageRegion(@RequestBody List<PageRegion> regionList) {
        pageRegionService.submitPageRegion(regionList);
        return success(200,"提交成功");
    }

    @RequestMapping("/delete_pageRegionByState")
    @ApiOperation(value = "删除区域", notes = "删除某个区域并更新顺序", httpMethod = "post")
    @ApiImplicitParam(name = "regionList",value = "所有区域信息",required = true)
    private ResponseVO deletePageRegionByState(@RequestBody List<PageRegion> regionList) {
        pageRegionService.deletePageRegionByState(regionList,new String[]{"0","2"});
        return success(200,"");
    }
}