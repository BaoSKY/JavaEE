package com.serviceImpl;

import com.service.SubmitService;
import com.mapper.SubmitMapper;
import com.model.Homework;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SubmitServiceImpl implements SubmitService {

    private SqlSession session = MybatisUtil.getSession();
    private SubmitMapper submitMapper = session.getMapper(SubmitMapper.class);

    @Override
    public void addSubmit(int sid, int hid) {
        submitMapper.addSubmit(sid, hid, Homework.SUBMIT_STATUS_DOING);
    }

    @Override
    public void submit(int sid, int hid, String content) {
        Date d = new Date(); // 注意是util包下的Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        String date = sdf.format(d);

        submitMapper.submit(sid, hid, Homework.SUBMIT_STATUS_SUBMITTED, content);
    }
}
