package edu.nf.shopping.comment.controller;

import edu.nf.shopping.comment.service.ReportService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
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

    @RequestMapping("/add_report")
    private ResponseVO addReport(String commentId, String reason, HttpServletRequest request){
        reportService.addReport(commentId,reason,"1578412684666");
        return success(200,"举报成功");
    }
}