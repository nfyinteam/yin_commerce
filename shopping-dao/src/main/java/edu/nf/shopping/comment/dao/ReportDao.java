package edu.nf.shopping.comment.dao;

import edu.nf.shopping.comment.entity.Report;

/**
 * @author Bull fighters
 * @date 2020/3/19
 */
public interface ReportDao {
    Report findReport(String reportId);
    void addReport(Report report);
    void updateReport(String comId,String state);
    void deleteReport(Report report);
}