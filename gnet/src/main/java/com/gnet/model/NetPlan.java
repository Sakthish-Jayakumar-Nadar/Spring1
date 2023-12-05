package com.gnet.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NetPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private int mbps;
	private String renew;
	private String expire;
	private int amount;
	private int balanceAmount;
	private int month;
	private int balanceMonth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMbps() {
		return mbps;
	}

	public void setMbps(int mbps) {
		this.mbps = mbps;
	}

	public String getRenew() {
		return renew;
	}

	public void setRenew(String renew) {
		this.renew = renew;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getBalanceMonth() {
		return balanceMonth;
	}

	public void setBalanceMonth(int balanceMonth) {
		this.balanceMonth = balanceMonth;
	}

	@Override
	public String toString() {
		return "NetPlan [id=" + id + ", mbps=" + mbps + ", renew=" + renew + ", expire=" + expire + ", amount=" + amount
				+ ", balanceAmount=" + balanceAmount + ", month=" + month + ", balanceMonth=" + balanceMonth + "]";
	}
	
	
	
}
	
	
