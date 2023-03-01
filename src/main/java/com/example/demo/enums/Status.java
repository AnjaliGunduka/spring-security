package com.example.demo.enums;

public enum Status {

	ACTIVE("ACTIVE"), INACTIVE("INACTIVE"), SUCCESS("SUCCUSS");

	private String status;

	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
