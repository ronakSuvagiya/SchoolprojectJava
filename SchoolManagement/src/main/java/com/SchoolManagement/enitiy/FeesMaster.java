package com.SchoolManagement.enitiy;



import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FeesMaster {

	@Id
	@GeneratedValue
	private Integer id;

	private long amount;

	private Date date;

	@ManyToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	private Student student;
	
	private String deatils;
	
	private boolean recipt = false;


	public boolean isRecipt() {
		return recipt;
	}

	public void setRecipt(boolean recipt) {
		this.recipt = recipt;
	}

	public String getDeatils() {
		return deatils;
	}

	public void setDeatils(String deatils) {
		this.deatils = deatils;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
