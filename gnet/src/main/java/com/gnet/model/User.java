package com.gnet.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	private String id;
	private String network;
	private String name;
	private String location;
	private long phone;
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public User() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "NetPlanInfo", referencedColumnName = "id")
	List<NetPlan> netPlan = new ArrayList<>();
	public List<NetPlan> getNetPlan() {
		return netPlan;
	}
	public void setNetPlan(List<NetPlan> netPlan) {
		this.netPlan = netPlan;
	}
}
