package edu.bjtu.javaee.homework.serviceImpl;

import edu.bjtu.javaee.homework.mapper.AssignMapper;
import edu.bjtu.javaee.homework.service.AssignService;
import edu.bjtu.javaee.homework.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AssignServiceImpl implements AssignService {

    @Override
    public void assign(int tid, int hid) {
        SqlSession session = MybatisUtil.getSession();
        AssignMapper assignMapper = session.getMapper(AssignMapper.class);
        assignMapper.assign(tid, hid);
        session.commit();
        session.close();
    }

    @Override
    public List<Integer> getHomeworkIdList(int tid) {
        SqlSession session = MybatisUtil.getSession();
        AssignMapper assignMapper = session.getMapper(AssignMapper.class);
        List<Integer> list = assignMapper.getHomeworkIdList(tid);
        session.commit();
        session.close();

        return list;
    }
}
