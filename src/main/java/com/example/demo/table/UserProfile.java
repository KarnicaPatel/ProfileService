package com.example.demo.table;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

//all are JPA annotations
@Component
@Entity
@Table(name="USER_PROFILE")
public class UserProfile {


	@Column(name="SYS_CREATION_DATE", updatable = false)
	@CreationTimestamp
	private Date creationDate;


	@Column(name="SYS_UPDATE_DATE", insertable = false)
	@UpdateTimestamp
	private Date updateDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_PROFILE_ID")
	private Long userProfileId;

	@Column(name="ACTIVATION_DATE")
	private Date activationDate;

	@Column(name="STATUS")
	private String status;	

	@Column(name="USERNAME")
	private String username;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="AGE")
	private Long age;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public UserProfile(Date creationDate, Date updateDate, Long userProfileId, Date activationDate, String status,
			String username, String firstName, String lastName, Long age) {
		super();
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.userProfileId = userProfileId;
		this.activationDate = activationDate;
		this.status = status;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserProfile [creationDate=" + creationDate + ", updateDate=" + updateDate + ", userProfileId="
				+ userProfileId + ", activationDate=" + activationDate + ", status=" + status + ", username=" + username
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

	
	public UserProfile () {

	}

}
