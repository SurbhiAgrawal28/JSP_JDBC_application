package studentdetails.bean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
    private String studentName;
    private int studentID;
    private Date dob;
    private int semester;
    private String dept;
    private String specialization;
    private double cgpa;
    public Student() {}
    public Student(String name,int id, Date date, String dept, int sem, String specialization,double cgpa)
    {
    	this.setStudentName(name);
    	this.setStudentID(id);
    	this.setDob(date);
    	this.setSemester(sem);
    	this.setDept(dept);
    	this.setSpecialization(specialization);
    	this.setCgpa(cgpa);
    }
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
    
}
