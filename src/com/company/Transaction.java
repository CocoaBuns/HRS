package com.company;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Transaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private double price;    //Total price of the transaction
	private int quantity;
	private LocalDateTime time;
	
	//create a new transaction
	public Transaction(String name, String description, double price,int quantity, LocalDateTime time){
		this.name=name;
		this.description=description;
		this.price=price;
		this.quantity=quantity;
		this.time =time;
	}
	
	public Transaction(Transaction trans){
		this.name=trans.getName();
		this.description=trans.getDescription();
		this.price=trans.getPrice();
		this.quantity=trans.getQuantity();
		this.time =trans.getTime();
				
	}
	
	public Transaction() {
		
	}

	public String toString() {
		NumberFormat currFormatter = NumberFormat.getCurrencyInstance();
		String formatPrice = currFormatter.format(price);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = time.format(formatter);
        return   String.format("%-20s %-39s %-10s %-11s %-20s", name, description, quantity ,formatPrice,formatDateTime);
	}
	
	//return name of the transaction
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	//return description of the transaction
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
	
	//return price of the transaction
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}
	
	//return quantity of the transaction
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	
	//return date of the transaction
	public LocalDateTime getTime() {
		return time;
	}
	
	public void setTime(LocalDateTime time) {
		this.time=time;
	}
}
