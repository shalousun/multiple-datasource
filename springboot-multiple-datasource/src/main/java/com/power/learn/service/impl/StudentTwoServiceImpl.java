package com.power.learn.service.impl;

import com.power.common.model.CommonResult;
import com.power.learn.dao.StudentTwoDao;
import com.power.learn.model.Student;
import com.power.learn.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("studentTwoService")
public class StudentTwoServiceImpl implements StudentService {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Resource
    private StudentTwoDao studentTwoDao;

    @Override
    public CommonResult save(Student entity) {
        try {
            studentTwoDao.save(entity);
            return CommonResult.ok();
        } catch (Exception e) {
            logger.error("StudentService添加数据异常：", e);
            return CommonResult.fail();
        }
    }

    @Override
    public CommonResult update(Student entity) {
        try {
            studentTwoDao.update(entity);
            return CommonResult.ok();
        } catch (Exception e) {
            logger.error("StudentService修改数据异常：", e);
            return CommonResult.fail();
        }
    }

    @Override
    public CommonResult delete(int id) {
        try {
            studentTwoDao.delete(id);
            return CommonResult.ok();
        } catch (Exception e) {
            logger.error("StudentService删除数据异常：", e);
            return CommonResult.fail();
        }
    }

    @Override
    public CommonResult queryById(int id) {
        Student entity = studentTwoDao.queryById(id);
        if (null != entity) {
            return CommonResult.ok().setResult(entity);
        } else {
            logger.info("StudentService未查询到数据，编号：{}", id);
            return CommonResult.fail();
        }
    }

    @Override
    public PageInfo queryPage(int offset, int limit) {
        PageHelper.offsetPage(offset,limit);
        List<Student> list = studentTwoDao.queryPage();
        return new PageInfo(list);
    }

    @Override
    public List<Map<String,Object>> queryToListMap(Map<String,Object> params){
        return studentTwoDao.queryToListMap(params);
    }
}
