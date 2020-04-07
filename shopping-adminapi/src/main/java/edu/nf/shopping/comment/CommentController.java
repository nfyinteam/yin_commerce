package edu.nf.shopping.comment;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.service.CommentService;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bull fighters
 * @date 2020/4/3
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/list/examine/comment")
    @ApiOperation(value = "查询买家秀", notes = "查询需要过审的买家秀",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    private ResponseVO<PageInfo<Comment>> listExamineComment(){
        return null;
    }


}