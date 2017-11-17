package com.longzheng.spring.boot.zhoujun.model;

import cn.lz.cloud.common.service.FieldNote;
import cn.lz.cloud.common.service.PojoNote;

/**
 * 
 * @author zhoujun1
 * @下午3:13:07
 * @2017年11月16日
 * @email:zhoujun1@icerno.com
 */
@PojoNote(desc = "学生", resource = "student")
public class Student {
	// @FieldNote(desc = "案例uuid", length = 50, notNull = true)
	@FieldNote(desc = "学生uuid", length = 50, notNull = true)
	private String uuid;
	@FieldNote(desc = "学号", length = 50, notNull = true)
	private String code;
	@FieldNote(desc = "年龄", length = 24, notNull = false)
	private Integer age;
	@FieldNote(desc = "班级名称", length = 50, notNull = false)
	private String className;

	@FieldNote(desc = "姓名", length = 24, notNull = false)
	private String name;
	@FieldNote(desc = "专业", length = 24, notNull = false)
	private String major;
	@FieldNote(desc = "创建时间", length = 50, notNull = false)
	private String createTime;
	@FieldNote(desc = "编辑时间", length = 50, notNull = false)
	private String editeTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major == null ? null : major.trim();
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEditeTime() {
		return editeTime;
	}

	public void setEditeTime(String editeTime) {
		this.editeTime = editeTime;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
