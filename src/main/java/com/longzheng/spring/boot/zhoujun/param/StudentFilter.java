package com.longzheng.spring.boot.zhoujun.param;

import com.longzheng.spring.boot.zhoujun.util.reqErrCodes;

import cn.lz.cloud.common.service.FieldNote;
import cn.lz.cloud.common.service.PojoNote;

/**
 * 
 * @author zhoujun1
 * @下午3:28:48
 * @2017年11月16日
 * @email:zhoujun1@icerno.com
 */
@PojoNote(desc = "案例输入参数", resource = "studentFilter")
public class StudentFilter {
	@FieldNote(desc = "专业", length = 24, notNull = false)
	private String major;
	@FieldNote(desc = "uuid", length = 50, notNull = true)
	private String uuid;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void isValidFilter() {

		if ((major == null || major.isEmpty()) && (uuid == null || uuid.isEmpty())) {
			throw reqErrCodes.FILTER_ERROR_CORP.exception("必须输入条件major和uuid");
		}
	}

}
