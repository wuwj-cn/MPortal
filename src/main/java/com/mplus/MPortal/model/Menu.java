package com.mplus.MPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import com.mplus.core.DataState;

@Entity
@Table(name = "t_menu")
public class Menu implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=32)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private String id;
	
	@Column(length = 32)
	@NotEmpty(message = "菜单编码不能为空")
	private String code;
	
	@NotEmpty(message = "菜单名称不能为空")
	private String name;
	
	@Column(name = "data_state", length = 1)
	@NotEmpty
	private String dataState = DataState.DEFAULT.toString();
	
	@ManyToOne
	@JoinColumn(name = "parent_code", referencedColumnName = "code")
	private Menu parent;
	
	public Menu(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public String getDataState() {
		return dataState;
	}

	public void setDataState(String dataState) {
		this.dataState = dataState;
	}
}
