package com.capacity.employee;

import java.util.List;

public class Allocation {
	
	private int totalWorkingDays;
	private int nationalHolidays;
	private int allocatedHrs;
	private List<Integer> allocated;
	private List<Double> fFactor;
	private double focusFactor;
	private double total;
	public int confirmationNumber;
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total2) {
		this.total = total2;
	}
	public int getTotalWorkingDays() {
		return totalWorkingDays;
	}
	public void setTotalWorkingDays( int totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}
	public int getNationalHolidays() {
		return nationalHolidays;
	}
	public void setNationalHolidays(int nationalHolidays) {
		this.nationalHolidays = nationalHolidays;
	}
	public int getAllocatedHrs() {
		return allocatedHrs;
	}
	public void setAllocatedHrs(int allocatedHrs) {
		this.allocatedHrs = allocatedHrs;
	}
	public double getFocusFactor() {
		return focusFactor;
	}
	public void setFocusFactor(double focusFactor) {
		this.focusFactor = focusFactor;
	}
	public List<Integer> getAllocated() {
		return allocated;
	}
	public void setAllocated(List<Integer> allocated) {
		this.allocated = allocated;
	}
	public List<Double> getfFactor() {
		return fFactor;
	}
	public void setfFactor(List<Double> fFactor) {
		this.fFactor = fFactor;
	}
	public int getConfirmationNumber() {
		return confirmationNumber;
	}
	public void setConfirmationNumber(int confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}
	


}
