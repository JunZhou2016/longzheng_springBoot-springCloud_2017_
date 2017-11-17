package com.longzheng.spring.boot.zhoujun.dao;

import java.util.List;

import com.longzheng.spring.boot.zhoujun.model.Student;
import com.longzheng.spring.boot.zhoujun.param.StudentFilter;

public interface StudentMapper {
	void save(Student stuent);

	int delete(List<String> list);

	void update(Student student);

	List<Student> selectAll();

	/**
	 * 根据uuid查询学生信息（唯一，不需要返回list结果） 根据专业（major）查询学生信息,返回list结果，实现分页功能
	 * 
	 * @param uuid
	 * @return
	 */
	List<Student> selectByCondition(StudentFilter studentFilter);
}