package com.zeeshan.hirearide.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *<h1>User</h1>
 * It is the domain or model class. also referred as POJO Class
 * Contains the mapping annotaion for ORM purpose. Maps User object to tbl_user in db
 *   
 * 
 * @author Muhamad Zeeshan
 * @version 1.0.0
 * @category POJO/model class
 * @since July 2016
 *
 */
@Entity
@Table(name = "tbl_user")
public class User implements java.io.Serializable{

	/**
	 *  id               -- uniquley identifies an object/record
	 *  username		 -- Name of the user
	 *  ssn		         -- SocailSecurityNumber of a user(currently not in use in application)
	 *  email            -- email of the user
	 *  password 		 -- password of a user (future use: email and password will be serving as the login info for a user)
	 *  status           -- status field currently for future use
	 * 
	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "ssn", nullable = false)
	private String ssn;
	
	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;
	
	
	@Column(name = "status", nullable = false)
	private String status;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}
}
