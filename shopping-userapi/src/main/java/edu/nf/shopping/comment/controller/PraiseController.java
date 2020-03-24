package edu.nf.shopping.comment.controller;

import edu.nf.shopping.comment.entity.Praise;
import edu.nf.shopping.comment.service.PraiseService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Bull fighters
 * @date 2020/3/19
 */
@RestController
public class PraiseController extends BaseController {

    @Autowired
    private PraiseService praiseService;

    @RequestMapping("/spot_praise")
    @ApiOperation(value = "举报评论", notes = "用户可以举报评论",
            httpMethod = "post")
    private ResponseVO spotPraise(String commentId, HttpServletRequest request){
        Boolean b=praiseService.spotPraise("1578412684666",commentId);
        return success(b);
    }
}