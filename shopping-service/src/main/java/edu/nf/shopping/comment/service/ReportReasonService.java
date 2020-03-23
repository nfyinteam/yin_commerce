package edu.nf.shopping.comment.service;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.ReportReason;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/20
 */
public interface ReportReasonService {

    List<ReportReason> listReportReason();

    void addReportReason(ReportReason reportReason);

    void updateReportReason(ReportReason reportReason);

    void deleteReportReason(String reaId);
}