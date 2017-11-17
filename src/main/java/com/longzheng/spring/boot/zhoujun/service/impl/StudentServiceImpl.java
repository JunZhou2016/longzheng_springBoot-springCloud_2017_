package com.longzheng.spring.boot.zhoujun.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longzheng.spring.boot.zhoujun.dao.StudentMapper;
import com.longzheng.spring.boot.zhoujun.model.Student;
import com.longzheng.spring.boot.zhoujun.param.StudentFilter;
import com.longzheng.spring.boot.zhoujun.service.StudentService;
import com.longzheng.spring.boot.zhoujun.util.reqErrCodes;

import cn.lz.cloud.common.exception.LzErrException;
import cn.lz.cloud.common.service.ReqObject;
import cn.lz.cloud.common.service.ReqQuery;
import cn.lz.cloud.common.service.ResList;
import cn.lz.cloud.common.util.DateUtil;
import cn.lz.cloud.common.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

	protected static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class.getName());

	@Autowired
	private StudentMapper studentDao;

	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public Student save(ReqObject<Student> data) {
		Student student = data.getObject();
		// 保存uuid(自动生成唯一uuid值)
		student.setUuid(UUID.getUUID());
		// 保存创建时间
		student.setCreateTime(DateUtil.longDateTime());
		studentDao.save(student);
		log.info("保存成功");
		return student;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public int delete(ReqObject<List<String>> data) {
		List<String> list = data.getObject();
		if (list != null && list.size() > 0) {
			return studentDao.delete(list);
		} else {
			log.error("删除信息为空，请选择删除信息");
			throw reqErrCodes.NO_MESSAGE_DELETED.exception();
		}

	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public Student update(ReqObject<Student> data) {
		Student student = data.getObject();
		// 保存修改时间
		student.setEditeTime(DateUtil.longDateTime());
		studentDao.update(student);
		log.info("保存成功");
		return student;
	}

	@Override
	public ResList<Student> selectByCondition(ReqObject<ReqQuery<StudentFilter>> filter) {
		// 获取起始页
		int startPage = filter.getObject().getStartPage();
		// 获取每页显示多少条
		int pageRow = filter.getObject().getPageRow();
		// 判断输入参数是否为空
		filter.getObject().getObject().isValidFilter();
		StudentFilter condition = filter.getObject().getObject();

		if (startPage == 0 && pageRow == 0) {
			List<Student> list = studentDao.selectByCondition(condition);
			ResList<Student> resList = new ResList<Student>(list);
			if (list.size() > ReqQuery.totalCount) {

				throw new LzErrException("900001", "数据过大，请分页");
			}
			return resList;
		}
		PageHelper.startPage(startPage, pageRow);
		PageInfo<Student> page = null;
		List<Student> list = studentDao.selectByCondition(condition);
		page = new PageInfo<Student>(list);
		ResList<Student> resList = new ResList<Student>(list);
		resList.setStartPage(startPage);
		resList.setPageRow(pageRow);
		resList.setTotalRow(page.getTotal());

		return resList;
	}
}
