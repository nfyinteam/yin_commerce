package edu.nf.shopping.comment.service.impl;

import edu.nf.shopping.comment.dao.CommentDao;
import edu.nf.shopping.comment.dao.ReportDao;
import edu.nf.shopping.comment.entity.Report;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.ReportService;
import edu.nf.shopping.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Bull fighters
 * @date 2020/3/20
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    public Report findReport(String reportId) {
        return null;
    }

    @Override
    public void addReport(String comId,String reason,String userId){
        try{
            if(commentDao.findComment(comId,null,null)==null){
                throw new CommentException("出错了！");
            }
            Report report=new Report();
            report.setReportId(UUIDUtils.createUUID());
            report.setWtbId(userId);
            report.setComId(comId);
            report.setReason(reason);
            report.setState("1");
            report.setTime(new Date());
            reportDao.addReport(report);
        }catch (CommentException e){
            throw e;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错了");
        }
    }

    @Override
    public void updateReport(Report report) {

    }

    @Override
    public void deleteReport(Report report) {

    }
}