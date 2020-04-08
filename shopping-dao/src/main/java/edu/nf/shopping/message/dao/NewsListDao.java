package edu.nf.shopping.message.dao;

import edu.nf.shopping.message.entity.NewsList;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/6
 */
public interface NewsListDao {

    List<NewsList> listNewList();
}