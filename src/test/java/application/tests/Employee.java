package application.tests;

import java.util.Arrays;

import org.apache.juneau.annotation.Beanc;

public class Employee {

	private String name;
	private int emp_id;
	private String dept;
	private String[] skills;

	@Beanc(properties = "name, emp_id, dept, skills")
	public Employee(String name, int emp_id, String dept, String[] skills) {
		this.emp_id = emp_id;
		this.dept = dept;
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", emp_id=" + emp_id + ", dept=" + dept + ", skills="
				+ Arrays.toString(skills) + "]";
	}
	
	

}
