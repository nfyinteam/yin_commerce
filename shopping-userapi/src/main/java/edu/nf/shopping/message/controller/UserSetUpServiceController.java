package edu.nf.shopping.message.controller;

import edu.nf.shopping.message.entity.UserSetUp;
import edu.nf.shopping.message.service.UserSetUpService;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/16
 */
@RestController
public class UserSetUpServiceController extends BaseController {

    @Autowired
    private UserSetUpService userSetUpService;

    @RequestMapping("/get/userSetUp")
    @ApiOperation(value = "查询设置" , notes = "查询用户的消息提示设置" ,httpMethod = "get")
    @CrossOrigin(origins = "*" ,methods = {RequestMethod.GET})
    private ResponseVO listUserMessageSetUp(HttpSession session){
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        List<UserSetUp> list=userSetUpService.listUserMessageSetUp(userInfo.getUserId());
        return success(list);
    }

    @RequestMapping("/post/userSetUp")
    @ApiOperation(value = "添加设置" , notes = "用户添加一个消息设置" ,httpMethod = "get")
    @CrossOrigin(origins = "*" ,methods = {RequestMethod.GET})
    private ResponseVO addUserMessageSetUp(String type,HttpSession session){
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        userSetUpService.addUserSetUp(userInfo.getUserId(),type);
        return success(200,"修改成功");
    }

    @RequestMapping("/delete/userSetUp")
    @ApiOperation(value = "删除设置" , notes = "用户删除一个消息设置" ,httpMethod = "get")
    @CrossOrigin(origins = "*" ,methods = {RequestMethod.GET})
    private ResponseVO deleteUserMessageSetUp(String type,HttpSession session){
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        userSetUpService.deleteUserSetUp(userInfo.getUserId(),type);
        return success(200,"修改成功");
    }
}