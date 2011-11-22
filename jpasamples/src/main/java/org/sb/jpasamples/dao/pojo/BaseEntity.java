package org.sb.jpasamples.dao.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity {

	@Version
	@Column(name = "VERSION")
	private Long version;
	
	@Column(name = "CREATE_USER")
	private String createUser;
	
	@Column(name = "CREATE_TIME")
	private Date createTime;
	
	@Column(name = "UPDATE_USER")
	private String updateUser;
	
	@Column(name = "UPDATE_TIME")
	private Date updateTime;

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
