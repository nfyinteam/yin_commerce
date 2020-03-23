package edu.nf.shopping.comment.dao;

import edu.nf.shopping.comment.entity.ReportReason;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/20
 */
public interface ReportReasonDao {

    List<ReportReason> listReportReason();

    void addReportReason(ReportReason reportReason);

    void updateReportReason(ReportReason reportReason);

    void deleteReportReason(String reaId);

}