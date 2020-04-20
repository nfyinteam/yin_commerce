package edu.nf.shopping.comment;

import edu.nf.shopping.comment.entity.Examine;
import edu.nf.shopping.comment.service.ExamineService;
import edu.nf.shopping.comment.service.ReportService;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Bull fighters
 * @date 2020/4/19
 */
@RestController
public class ExamineController extends BaseController {

    @Autowired
    private ExamineService examineService;

    @RequestMapping("/patch/examine/buyShow/pass")
    @ApiOperation(value = "审核买家秀", notes = "审核结果为通过的买家秀",
            httpMethod = "patch")
    @CrossOrigin(origins = "*", methods = {RequestMethod.PATCH})
    private ResponseVO updateAuditPassBuyShow(@RequestBody Examine examine, HttpSession session){
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        examine.setStaffId(userInfo.getUserId());
        examineService.updateAuditPassBuyShow(examine,"1");
        return success(200,"审核成功");
    }

    @RequestMapping("/patch/examine/buyShow/failure")
    @ApiOperation(value = "审核买家秀", notes = "审核结果为违规的买家秀",
            httpMethod = "patch")
    @CrossOrigin(origins = "*", methods = {RequestMethod.PATCH})
    private ResponseVO updateAuditFailureBuyShow(@RequestBody Examine examine, HttpSession session){
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        examineService.updateAuditFailureBuyShow(examine,"0",userInfo.getUserId());
        return success(200,"审核结果已提交");
    }


}