package edu.nf.shopping.comment.service;

import edu.nf.shopping.comment.entity.Praise;

/**
 * @author Bull fighters
 * @date 2020/3/19
 */
public interface PraiseService {
    Praise findPraise(String userId,String comId);
    void spotPraise(String userId, String comId,String goodsId);
    void deletePraise(String userId,String comId);
}