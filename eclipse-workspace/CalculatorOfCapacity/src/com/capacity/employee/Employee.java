package com.capacity.employee;

public class Employee {
	
	private String teamMember;
	
	
	private int leaves;
	
	public String getTeamMember() {
		return teamMember;
	}
	public void setTeamMember(String teamMember) {
		this.teamMember = teamMember;
	}
	public int getLeaves() {
		return leaves;
	}
	public void setLeaves(int count) {
		this.leaves = count;
	}
	@Override
	public String toString() {
		return "Employee [teamMember=" + teamMember + ", leaves=" + leaves + "]";
	}
	
	
	

}
