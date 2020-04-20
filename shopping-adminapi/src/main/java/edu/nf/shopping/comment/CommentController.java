package edu.nf.shopping.comment;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.service.CommentService;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Bull fighters
 * @date 2020/4/3
 */
@RestController
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/list/examine/buyShow/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询买家秀", notes = "查询需要审的的买家秀",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum" , value = "页码"),
            @ApiImplicitParam(name = "pageSize" , value = "条目数")
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO<PageInfo<Comment>>
        listStayToExamineBuyShow(@PathVariable("pageNum") Integer pageNum,
                                 @PathVariable("pageSize") Integer pageSize){
        PageInfo<Comment> pageInfo=commentService.listStayToExamineBuyShow(pageNum,pageSize);
        return success(pageInfo);
    }

    @RequestMapping("/list/report/buyShow/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询买家秀", notes = "查询被举报买家秀",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum" , value = "页码"),
            @ApiImplicitParam(name = "pageSize" , value = "条目数")
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO<PageInfo<Comment>>
        listReportBuyShow(@PathVariable("pageNum") Integer pageNum,
                          @PathVariable("pageSize") Integer pageSize){
        PageInfo<Comment> pageInfo=commentService.listReportComment(pageNum,pageSize,"1");
        return success(pageInfo);
    }

    @RequestMapping("/list/report/comment/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询评论", notes = "查询被举报的评论",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum" , value = "页码"),
            @ApiImplicitParam(name = "pageSize" , value = "条目数")
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO<PageInfo<Comment>>
        listReportComment(@PathVariable("pageNum") Integer pageNum,
                          @PathVariable("pageSize") Integer pageSize){
            PageInfo<Comment> pageInfo=commentService.listReportComment(pageNum,pageSize,"0");
            return success(pageInfo);
    }
}