package edu.nf.shopping.comment.service.impl;

import edu.nf.shopping.comment.dao.CommentDao;
import edu.nf.shopping.comment.dao.ExamineDao;
import edu.nf.shopping.comment.dao.ReportDao;
import edu.nf.shopping.comment.entity.Examine;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.ExamineService;
import edu.nf.shopping.message.dao.NoticeDao;
import edu.nf.shopping.message.dao.ReceiveDao;
import edu.nf.shopping.message.entity.Notice;
import edu.nf.shopping.message.entity.Receive;
import edu.nf.shopping.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Bull fighters
 * @date 2020/4/19
 */
@Service("examineService")
@Transactional(rollbackFor = RuntimeException.class)
public class ExamineServiceImpl implements ExamineService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ExamineDao examineDao;

    @Autowired
    private ReportDao reportDao;

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private ReceiveDao receiveDao;

    /**
     * 审核结果为通过的买家秀
     * @param examine
     * @param state
     */
    @Override
    public void updateAuditPassBuyShow(Examine examine, String state) {
        try{
            if("".equals(examine.getComId())|| examine.getComId()==null){
                throw new CommentException("数据出错了");
            }
            examine.setExamineId(UUIDUtils.createUUID());
            examine.setType("1");
            examine.setTime(new Date());
            System.out.println(examine);
            if(commentDao.updateComment(examine.getComId(),state)<=0){
                throw new CommentException("数据出错了");
            }
            examineDao.addExamine(examine);
        }catch (CommentException e){
            throw e;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    /**
     * 审核结果为失败的买家秀
     * @param examine
     * @param state
     * @param userId
     */
    @Override
    public void updateAuditFailureBuyShow(Examine examine, String state, String userId) {
        try{
            if("".equals(examine.getComId())|| examine.getComId()==null){
                throw new CommentException("数据出错了");
            }
            examine.setExamineId(examine.getComUserId()+examine.getComId());
            examine.setType("1");
            examineHandle(examine,state);
            Receive receive=new Receive();
            receive.setMessageId(examine.getExamineId());
            receive.setReceiveUserId(examine.getComUserId());
            receive.setState("1");
            System.out.println(receive);
            System.out.println(examine);
            //receiveDao.addReceive(receive);
        }catch (CommentException e){
            throw e;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    @Override
    public void updateReportPassComment(Examine examine, String state, String userId) {

    }

    @Override
    public void updateReportFailureComment(Examine examine, String state, String userId) {

    }

    /**
     * 审核结果为违规要处理的事情
     * @param examine
     * @param state
     */
    private void examineHandle(Examine examine,String state){
        examine.setTime(new Date());
        Notice notice=new Notice();
        notice.setNoticeId(examine.getExamineId());
        notice.setTitle("买家秀审核结果");
        notice.setContent(examine.getReason());
        notice.setLink("#");
        notice.setComId(examine.getComId());
        notice.setAuthor(examine.getStaffId());
        notice.setType("2");
        notice.setTime(examine.getTime());
        System.out.println(notice);
        if(commentDao.updateComment(examine.getComId(),state)<=0){
            throw new CommentException("数据出错了");
        }
        //reportDao.updateReport(examine.getComId(),"2");
        //examineDao.addExamine(examine);
        //noticeDao.addNotice(notice);
    }
}