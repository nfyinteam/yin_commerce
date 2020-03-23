package edu.nf.shopping.comment.dao;

import edu.nf.shopping.comment.entity.ImgInfo;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/23
 */
public interface ImgInfoDao {
    List<ImgInfo> listImgInfo(String comId);

    void addImgInfo(ImgInfo imgInfo);
}