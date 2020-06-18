package edu.bjtu.javaee.homework.serviceImpl;

import edu.bjtu.javaee.homework.mapper.HomeworkMapper;
import edu.bjtu.javaee.homework.model.Homework;
import edu.bjtu.javaee.homework.service.HomeworkService;
import edu.bjtu.javaee.homework.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HomeworkServiceImpl implements HomeworkService {

    @Override
    public boolean addHomework(String title, String requirement) {
        SqlSession session = MybatisUtil.getSession();
        HomeworkMapper homeworkMapper = session.getMapper(HomeworkMapper.class);
        boolean b = homeworkMapper.addHomework(title, requirement);
        session.commit();
        session.close();
        return b;
    }

    @Override
    public List<Homework> getAllHomework() {
        SqlSession session = MybatisUtil.getSession();
        HomeworkMapper homeworkMapper = session.getMapper(HomeworkMapper.class);
        session.commit();
        session.close();
        return homeworkMapper.getAllHomework();
    }

    @Override
    public Homework getHomeworkByTitle(String title) {
        SqlSession session = MybatisUtil.getSession();
        HomeworkMapper homeworkMapper = session.getMapper(HomeworkMapper.class);
        Homework homework = homeworkMapper.getHomeworkByTitle(title);
        session.commit();
        session.close();
        return homework;
    }

    @Override
    public List<Homework> getHomeworkOfTeacher(int tid) {
        SqlSession session = MybatisUtil.getSession();
        HomeworkMapper homeworkMapper = session.getMapper(HomeworkMapper.class);
        List<Homework> homeworkList = homeworkMapper.getHomeworkOfTeacher(tid);
        session.commit();
        session.close();
        return homeworkList;
    }

    @Override
    public List<Homework> getHomeworkOfStudent(int sid) {
        SqlSession session = MybatisUtil.getSession();
        HomeworkMapper homeworkMapper = session.getMapper(HomeworkMapper.class);
        List<Homework> homeworkList =homeworkMapper.getHomeworkOfStudent(sid);
        session.commit();
        session.close();
        return homeworkList;
    }

    @Override
    public Homework getHomeworkById(int hid) {
        SqlSession session = MybatisUtil.getSession();
        HomeworkMapper homeworkMapper = session.getMapper(HomeworkMapper.class);
        Homework homework = homeworkMapper.getHomeworkById(hid);
        session.commit();
        session.close();
        return homework;
    }
}
