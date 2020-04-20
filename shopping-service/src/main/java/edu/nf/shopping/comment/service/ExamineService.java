package edu.nf.shopping.comment.service;

import edu.nf.shopping.comment.entity.Examine;

/**
 * @author Bull fighters
 * @date 2020/4/19
 */
public interface ExamineService {
    /**
     *修改审核结果为通过的买家秀的状态
     **/
    void updateAuditPassBuyShow(Examine examine, String state);

    /**
     *修改审核结果为违规的买家秀的状态
     **/
    void updateAuditFailureBuyShow(Examine examine,String state,String userId);

    /**
     *修改举报结果为通过的评论的状态
     **/
    void updateReportPassComment(Examine examine,String stat,String userId);

    /**
     *修改举报结果违规的评论的状态
     **/
    void updateReportFailureComment(Examine examine,String state,String userId);

}