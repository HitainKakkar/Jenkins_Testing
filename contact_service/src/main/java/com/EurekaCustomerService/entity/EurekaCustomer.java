package com.EurekaCustomerService.entity;

import java.util.ArrayList;
import java.util.List;

public class EurekaCustomer {
	
	List<EurekaCustomer> eurekaCustomers = new ArrayList<>();
    private Long id;
    private String name;
    private String number;
    private int age;
    private String city;
    
    private double balance;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<EurekaCustomer> getEurekaCustomers() {
		return eurekaCustomers;
	}
	public void setEurekaCustomers(List<EurekaCustomer> eurekaCustomers) {
		this.eurekaCustomers = eurekaCustomers;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
