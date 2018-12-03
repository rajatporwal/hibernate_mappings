package com.userDashboard.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetail {

	// annotate the class as an entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names
	
	// create constructors
	
	// generate getter/setter methods
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int userDetailId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="about_yourself")
	private String aboutYourself;
	
	@Column(name="hobby")
	private String hobby;
	
	@Column(name="age_group")
	private int ageGroup;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="country_id")
	private int country;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(targetEntity=Country.class, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="country_id", insertable = false, updatable = false)
	private Country countryName;
	
	public UserDetail() {
		
	}
	
	public UserDetail(String email, String firstName, String lastName, String contactNo, Date dob, String aboutYourself,
			String hobby, int ageGroup, String gender, int country) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.dob = dob;
		this.aboutYourself = aboutYourself;
		this.hobby = hobby;
		this.ageGroup = ageGroup;
		this.gender = gender;
		this.country = country;
	}

	public int getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(int userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAboutYourself() {
		return aboutYourself;
	}

	public void setAboutYourself(String aboutYourself) {
		this.aboutYourself = aboutYourself;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Country getCountryName() {
		return countryName;
	}

	public void setCountryName(Country countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetail [userDetailId=");
		builder.append(userDetailId);
		builder.append(", email=");
		builder.append(email);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", contactNo=");
		builder.append(contactNo);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", aboutYourself=");
		builder.append(aboutYourself);
		builder.append(", hobby=");
		builder.append(hobby);
		builder.append(", ageGroup=");
		builder.append(ageGroup);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", country=");
		builder.append(country);
		builder.append("]");
		return builder.toString();
	}
	
}







