package edu.nf.shopping.comment.controller;

import edu.nf.shopping.comment.service.ReportService;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Bull fighters
 * @date 2020/3/20
 */
@RestController
public class ReportController extends BaseController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/post/report")
    @ApiOperation(value = "举报", notes = "用户可以举报某个评论",
            httpMethod = "post")
    private ResponseVO addReport(String commentId, String reason, HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        reportService.addReport(commentId,reason,userInfo.getUserId());
        return success(200,"举报成功");
    }
}