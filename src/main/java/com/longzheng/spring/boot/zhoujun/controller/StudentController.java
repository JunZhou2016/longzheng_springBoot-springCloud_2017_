package com.longzheng.spring.boot.zhoujun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longzheng.spring.boot.zhoujun.model.Student;
import com.longzheng.spring.boot.zhoujun.param.StudentFilter;
import com.longzheng.spring.boot.zhoujun.service.StudentService;

import cn.lz.cloud.common.service.ClazzNote;
import cn.lz.cloud.common.service.ReqObject;
import cn.lz.cloud.common.service.ReqQuery;
import cn.lz.cloud.common.service.ResList;
import cn.lz.cloud.common.service.ResObject;
import cn.lz.cloud.common.service.ServiceNote;

/**
 * 
 * @author zhoujun1
 * @下午4:40:01
 * @2017年11月16日
 * @email:zhoujun1@icerno.com
 */
@RestController
@RequestMapping("/student")
@ClazzNote(desc = "学生", resource = "student", modName = "学生")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// 新增
	@RequestMapping("/save")
	@ServiceNote(desc = "新增", auth = ServiceNote.AUTH.CHECK)
	public ResObject<Student> save(@RequestBody ReqObject<Student> data) {
		try {
			Student student = studentService.save(data);
			return new ResObject<Student>(data, student);
		} catch (Exception e) {
			return new ResObject<Student>(data, e);
		}
	}

	// 修改
	@RequestMapping("/update")
	public ResObject<Student> update(@RequestBody ReqObject<Student> data) {
		try {
			Student student = studentService.update(data);
			return new ResObject<Student>(data, student);
		} catch (Exception e) {
			return new ResObject<Student>(data, e);
		}
	}

	// 根据条件查询
	@RequestMapping("/selectByCondition")
	public ResObject<ResList<Student>> selectByCondition(@RequestBody ReqObject<ReqQuery<StudentFilter>> filter) {
		try {
			ResList<Student> student = studentService.selectByCondition(filter);
			return new ResObject<ResList<Student>>(filter, student);
		} catch (Exception e) {
			return new ResObject<ResList<Student>>(filter, e);
		}
	}

	// 批量删除
	@RequestMapping("/delete")
	public ResObject<Integer> delete(@RequestBody ReqObject<List<String>> data) {
		try {
			Integer row = studentService.delete(data);
			return new ResObject<Integer>(data, row);
		} catch (Exception e) {
			return new ResObject<Integer>(data, e);
		}
	}
}
