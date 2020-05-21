package com.serviceImpl;

import com.service.AssignService;
import com.mapper.AssignMapper;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class AssignServiceImpl implements AssignService {

    private SqlSession session = MybatisUtil.getSession();
    private AssignMapper assignMapper = session.getMapper(AssignMapper.class);

    @Override
    public void assign(int tid, int hid) {
        assignMapper.assign(tid, hid);
    }
}
