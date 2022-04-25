package com.niit;

public class Routes {

	private String source;
	private String destination;
	private String distance;
	private String time;
	private String cost;
	@Override
	public String toString() {
		System.out.format("\n%-20s %-20s %-20s %-20s %-20s\n",source,destination,distance,time,cost);
		return "";
	}
	public Routes(String source, String destination, String distance, String time, String cost) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.time = time;
		this.cost = cost;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
}
