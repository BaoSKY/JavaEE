package edu.bjtu.javaee.homework.serviceImpl;

import edu.bjtu.javaee.homework.mapper.SubmitMapper;
import edu.bjtu.javaee.homework.model.Homework;
import edu.bjtu.javaee.homework.model.Submit;
import edu.bjtu.javaee.homework.service.SubmitService;
import edu.bjtu.javaee.homework.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SubmitServiceImpl implements SubmitService {
SqlSession session = MybatisUtil.getSession();


    @Override
    public void addSubmit(int sid, int hid) {
        SqlSession session = MybatisUtil.getSession();
        SubmitMapper submitMapper = session.getMapper(SubmitMapper.class);
        submitMapper.addSubmit(sid, hid, Homework.SUBMIT_STATUS_DOING);
        session.commit();
        session.close();
    }

    @Override
    public void submit(int sid, int hid, String content) {
        SqlSession session = MybatisUtil.getSession();
        SubmitMapper submitMapper = session.getMapper(SubmitMapper.class);
        Date d = new Date(); // 注意是util包下的Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        String date = sdf.format(d);

        submitMapper.submit(sid, hid, Homework.SUBMIT_STATUS_SUBMITTED, content);
        session.commit();
        session.close();
    }

    @Override
    public String getContent(int sid, int hid) {
        SqlSession session = MybatisUtil.getSession();
        SubmitMapper submitMapper = session.getMapper(SubmitMapper.class);

        String content = submitMapper.getContent(sid, hid);
        session.commit();
        session.close();

        return content;
    }

    @Override
    public List<Submit> getSubmitByHid(int hid) {
        SqlSession session = MybatisUtil.getSession();
        SubmitMapper submitMapper = session.getMapper(SubmitMapper.class);

        List<Submit> submitList= submitMapper.getSubmitByHid(hid);
        session.commit();
        session.close();

        return submitList;
    }
}
