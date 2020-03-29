package edu.nf.shopping.page;

import edu.nf.shopping.page.entity.PageRegion;
import edu.nf.shopping.page.service.PageRegionService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/29
 */
@RestController
public class PageRegionController extends BaseController {

    @Autowired
    private PageRegionService pageRegionService;

    @RequestMapping("/list_pageRegion")
    private ResponseVO listHomePage() {
        List<PageRegion> list=pageRegionService.listPageRegion(new String[]{"1","3"});
        return success(list);
    }
}