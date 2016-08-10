package com.moke.MPortal.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户
 *
 */
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @Column(length=32)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
    private String id;
    
    @NotEmpty(message = "用户名不能为空")
    private String username;
    
    @NotEmpty(message = "密码不能为空")
    private String password;    
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole userRole;// 一个用户对应多个角色

    public User() {}

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Transient
	public List<Role> getRoleList() {
//		return roleList;
		return Collections.EMPTY_LIST;
	}

	@Transient
	public void setRoleList(List<Role> roleList) {
//		this.roleList = roleList;
	}

	@Transient
    public Set<String> getRolesName() {
        List<Role> roles = getRoleList();
        Set<String> set = new HashSet<String>();
        for (Role role : roles) {
            set.add(role.getRolename());
        }
        return set;
    }

}
