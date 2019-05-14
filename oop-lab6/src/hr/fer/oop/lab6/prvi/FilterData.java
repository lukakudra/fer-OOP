package hr.fer.oop.lab6.prvi;

/**
 * This class is used for filtering data. It consists of number of getters and setters
 * that are used in other classes to filter the given data.
 * @author Luka
 *
 */

public class FilterData {
	private boolean skipRecords;
	private int skip;
	private boolean leaveRecords;
	private int leave;
	private boolean filterByType;
	private PaymentType paymentType;
	private boolean limitDistance;
	private String operator;
	private double distance;
	private boolean totalMiles;
	private double miles;
	
	
	public boolean isSkipRecords() {
		return skipRecords;
	}
	
	public void setSkipRecords(boolean skipRecords) {
		this.skipRecords=skipRecords;
	}
	
	public int getSkip() {
		return skip;
	}
	
	public void setSkip(int skip) {
		this.skip=skip;
	}
	
	public boolean isLeaveRecords() {
		return leaveRecords;
	}
	
	public void setLeaveRecords(boolean leaveRecords) {
		this.leaveRecords=leaveRecords;
	}
	
	public int getLeave() {
		return leave;
	}
	
	public void setLeave(int leave) {
		this.leave=leave;
	}
	
	public boolean isFilterByType() {
		return filterByType;
	}
	
	public void setFilterByType(boolean filterByType) {
		this.filterByType=filterByType;
	}
	
	public PaymentType getPaymentType() {
		return paymentType;
	}
	
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType=paymentType;
	}
	
	public boolean isLimitDistance() {
		return limitDistance;
	}
	
	public void setLimitDistance(boolean limitDistance) {
		this.limitDistance=limitDistance;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator=operator;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance=distance;
	}
	
	public boolean isTotalMiles() {
		return totalMiles;
	}
	
	public void setTotalMiles(boolean totalMiles) {
		this.totalMiles=totalMiles;
	}
	
	public double getMiles() {
		return miles;
	}
	
	public void setMiles(double miles) {
		this.miles=miles;
	}
}
