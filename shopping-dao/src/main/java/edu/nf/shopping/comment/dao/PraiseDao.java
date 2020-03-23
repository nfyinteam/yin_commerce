package edu.nf.shopping.comment.dao;

import edu.nf.shopping.comment.entity.Praise;

/**
 * @author Bull fighters
 * @date 2020/3/19
 */
public interface PraiseDao {
    Praise findPraise(String userId,String comId);
    void addPraise(Praise praise);
    void deletePraise(String userId,String comId);
}