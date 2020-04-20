package edu.nf.shopping.comment.service;

import edu.nf.shopping.comment.entity.Report;

/**
 * @author Bull fighters
 * @date 2020/3/20
 */
public interface ReportService {
    Report findReport(String reportId);
    void addReport(String comId,String reason,String userId);
    void deleteReport(Report report);
}