package edu.nf.shopping.message.dao;

import edu.nf.shopping.message.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
public interface NewsDao {

    List<News> listNews(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, String userId, String staffId, String goodsId);

    void addNews(News news);

}