package edu.nf.shopping.comment.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.dao.ReportReasonDao;
import edu.nf.shopping.comment.entity.Report;
import edu.nf.shopping.comment.entity.ReportReason;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.ReportReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/20
 */
@Service("reportReasonService")
public class ReportReasonServiceImpl implements ReportReasonService {

    @Autowired
    private ReportReasonDao reportReasonDao;

    @Override
    public List<ReportReason> listReportReason() {
        try{
            List<ReportReason> list=reportReasonDao.listReportReason();
            return list;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错了");
        }
    }

    @Override
    public void addReportReason(ReportReason reportReason) {

    }

    @Override
    public void updateReportReason(ReportReason reportReason) {

    }

    @Override
    public void deleteReportReason(String reaId) {

    }
}