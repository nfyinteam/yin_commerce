package edu.nf.shopping.page;

import edu.nf.shopping.page.entity.PageRegion;
import edu.nf.shopping.page.service.PageRegionService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/29
 */
@RestController
public class PageRegionController extends BaseController {

    @Autowired
    private PageRegionService pageRegionService;

    @GetMapping("/list_pageRegion")
    @ApiOperation(value = "加载区域", notes = "加载页面",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO listHomePage() {
        List<PageRegion> list=pageRegionService.listPageRegion(new String[]{"1","3"});
        return success(list);
    }
}