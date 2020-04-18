package edu.nf.shopping.message.controller;

import edu.nf.shopping.message.entity.Notice;
import edu.nf.shopping.message.service.NoticeService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/4
 */
@RestController
public class NoticeController extends BaseController {

    @Autowired
    private NoticeService noticeService;



    @RequestMapping("/get/notice/system")
    @ApiOperation(value = "查询系统消息", notes = "用户查询自己的回复消息",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO listUserSystem(HttpServletRequest request){
        List<Notice> list=noticeService.userListNotice("2","1578412684666");
        return success(list);
    }

}