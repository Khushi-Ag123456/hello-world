package com.metacube.StudentJPA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * POJO of student
 * @author Khushi
 *
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId", nullable = false, unique = true)
	private int studentId;
	
	@NotBlank(message = "{blankMsg}")
	@Size(min = 3, message = "{firstNameMsg}")
	@Pattern(regexp = "^[A-Za-z]+$", message = "{firstNameRegExpMsg}")
	@Column(name = "firstName")
	private String firstName;
	
	@NotBlank(message = "{blankMsg}")
	@Size(min = 3, message = "{lastNameMsg}")
	@Pattern(regexp = "^[A-Za-z]+$", message = "{firstNameRegExpMsg}")
	@Column(name = "lastName")
	private String lastName;
	
	@NotBlank(message = "{blankMsg}")
	@Size(min = 3, message = "{lastNameMsg}")
	@Pattern(regexp = "[A-Za-z\\s]+", message = "{firstNameRegExpMsg}")
	@Column(name = "fatherName")
	private String fatherName;
	
	@NotBlank(message = "{blankMsg}")
	@Pattern(regexp = "^[A-Za-z0-9.]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,4}$", message = "{emailMsg}")
	@Column(name = "emailId", unique = true)
	private String emailId;
	
	@NotNull(message = "{blankMsg}")
	@Min(value = 1, message = "{minClassMsg}")
	@Max(value = 12, message = "{maxClassMsg}")
	@Column(name = "studentClass")
	private Integer studentClass;
	
	@NotNull(message = "{blankMsg}")
	//@Pattern(regexp = "[0-9]{1,3}", message = "{ageMsg}")
	@Column(name= "age")
	private Integer age;
	
	/**
	 * default constructor
	 */
	public Student() {}
	
	/**
	 * parameterized constructor
	 * @param firstName
	 * @param lastName
	 * @param fatherName
	 * @param emailId
	 * @param studentClass
	 * @param age
	 */
	public Student(String firstName, String lastName, String fatherName,
			String emailId, int studentClass, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.emailId = emailId;
		this.studentClass = studentClass;
		this.age = age;
		// TODO Auto-generated constructor stub
	}

	/**
	 * getter for firstName
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Setter for firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * getter for lastName
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * setter for lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * getter for father's name
	 * @return father's Name
	 */
	public String getFatherName() {
		return fatherName;
	}
	
	/**
	 * setter for father's name
	 * @param fatherName
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	/**
	 * getter for emailId
	 * @return email Id
	 */
	public String getEmailId() {
		return emailId;
	}
	
	/**
	 * setter for email ID
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * getter for student class
	 * @return student class
	 */
	public Integer getStudentClass() {
		return studentClass;
	}
	
	/**
	 * setter for student class
	 * @param studentClass
	 */
	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}
	
	/**
	 * getter for student age
	 * @return student age
	 */
	public Integer getAge() {
		return age;
	}
	
	/**
	 * setter for student age
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	

	@Override
	public String toString() {
		return "firstName = " + firstName + " lastName = " + lastName +  " fatherName = " + fatherName + " emailId = " + emailId + " studentClass = " + studentClass + " äge = " + age;
	}
}
