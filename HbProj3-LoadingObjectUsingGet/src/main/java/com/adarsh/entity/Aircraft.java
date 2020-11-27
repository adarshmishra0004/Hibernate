package com.adarsh.entity;

import java.io.Serializable;

public class Aircraft implements Serializable {
	private int aid;
	private String atype;
	private Integer noEngines;
	private String manuCompany;

	public Aircraft() {
		System.out.println("Aircraft-0 param constructor");
	}
	
	public Aircraft(String atype, Integer noEngines, String manuCompany) {
		this.atype = atype;
		this.noEngines = noEngines;
		this.manuCompany = manuCompany;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public Integer getNoEngines() {
		return noEngines;
	}

	public void setNoEngines(Integer noEngines) {
		this.noEngines = noEngines;
	}

	public String getManuCompany() {
		return manuCompany;
	}

	public void setManuCompany(String manuCompany) {
		this.manuCompany = manuCompany;
	}

	@Override
	public String toString() {
		return "Aircraft [aid=" + aid + ", atype=" + atype + ", noEngines=" + noEngines + ", manuCompany=" + manuCompany
				+ "]";
	}

}
