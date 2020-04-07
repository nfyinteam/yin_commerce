package edu.nf.shopping.message.controller;

import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.service.NewsService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/6
 */
@RestController
public class NewsController extends BaseController{

    @Autowired
    private NewsService newsService;

    @RequestMapping("/list/whisper/{goodsId}")
    @ApiOperation(value = "查询聊天记录", notes = "用户查询单个聊天记录",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品编号", required = true)
    })
    private ResponseVO listUserNews(@PathVariable("goodsId") String goodsId, HttpServletRequest request){
        List<News> list=newsService.listUserNews(1,10,"1578412684666",goodsId);
        return success(list);
    }
}