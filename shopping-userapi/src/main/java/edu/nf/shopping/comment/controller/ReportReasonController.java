package edu.nf.shopping.comment.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.ReportReason;
import edu.nf.shopping.comment.service.ReportReasonService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/20
 */
@RestController
public class ReportReasonController extends BaseController {

    @Autowired
    private ReportReasonService reportReasonService;

    @RequestMapping("/list_reportReason")
    private ResponseVO listReportReason(){
        List<ReportReason> list=reportReasonService.listReportReason();
        System.out.println(list.size());
        return success(list);
    }
}