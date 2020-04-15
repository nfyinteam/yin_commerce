package edu.nf.shopping.comment.controller;

import edu.nf.shopping.comment.entity.Praise;
import edu.nf.shopping.comment.service.PraiseService;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/post/praise")
    @ApiOperation(value = "点赞", notes = "用户给评论的点赞",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    private ResponseVO spotPraise(String commentId,String goodsId,String receiveUserId, HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        praiseService.spotPraise(userInfo.getUserId(),commentId,goodsId,receiveUserId);
        return success(200,"");
    }
}