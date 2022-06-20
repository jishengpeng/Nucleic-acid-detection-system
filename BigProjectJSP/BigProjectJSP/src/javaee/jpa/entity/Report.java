package javaee.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the report database table.
 * 
 */
@Entity
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String reportid;

	private String result;

	private String studentid;

	private String studentname;

	public Report() {
	}

	public String getReportid() {
		return this.reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStudentid() {
		return this.studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return this.studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

}