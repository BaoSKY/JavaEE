package com.serviceImpl;

import com.service.HomeworkService;
import com.mapper.HomeworkMapper;
import com.model.Homework;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HomeworkServiceImpl implements HomeworkService {

    private SqlSession session = MybatisUtil.getSession();
    private HomeworkMapper homeworkMapper = session.getMapper(HomeworkMapper.class);

    @Override
    public boolean addHomework(String title, String requirement) {
        return homeworkMapper.addHomework(title, requirement);
    }

    @Override
    public List<Homework> getAllHomework() {
        return homeworkMapper.getAllHomework();
    }

    @Override
    public Homework getHomeworkByTitle(String title) {
        return homeworkMapper.getHomeworkByTitle(title);
    }

    @Override
    public List<Homework> getHomeworkOfTeacher(int tid) {
        return homeworkMapper.getHomeworkOfTeacher(tid);
    }

    @Override
    public List<Homework> getHomeworkOfStudent(int sid) {
        return homeworkMapper.getHomeworkOfStudent(sid);
    }
}
