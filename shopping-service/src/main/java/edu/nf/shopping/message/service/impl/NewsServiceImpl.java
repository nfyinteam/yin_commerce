package edu.nf.shopping.message.service.impl;

import edu.nf.shopping.message.dao.NewsDao;
import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.entity.Notice;
import edu.nf.shopping.message.exception.MessageException;
import edu.nf.shopping.message.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/6
 */
@Service("newsService")
@Transactional(rollbackFor = {RuntimeException.class})
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> listUserNews(Integer pageNum, Integer pageSize, String userId, String goodsId) {
        try{
            List<News> list=newsDao.listUserNews(pageNum,pageSize,userId,goodsId);
            return list;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new MessageException("数据库出错");
        }
    }

    @Override
    public void addNews(News news) {

    }
}