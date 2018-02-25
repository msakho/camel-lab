package com.redhat.training.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

//Annotated with Bindy
@CsvRecord(separator = ",", crlf = "UNIX")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@DataField(pos = 1)
	@XmlAttribute
	private String name;
	
	@DataField(pos = 2, pattern = "MM/dd/yy")
	@XmlAttribute
	private Date orderDate;
	
	@DataField(pos = 3)
	@XmlAttribute
	private String street;
	
	@DataField(pos = 4)
	@XmlAttribute
	private String city;
	
	@DataField(pos = 5)
	@XmlAttribute
	private String state;
	
	@DataField(pos = 6)
	@XmlAttribute
	private String book;
	
	@DataField(pos = 7)
	@XmlAttribute
	private int quantity;
	
	@DataField(pos = 8, precision = 2)
	@XmlAttribute
	private BigDecimal extendedAmount;
	@XmlAttribute
	private String filename;

	@Override
	public String toString() {
		return "Order [name=" + name + ", orderDate=" + orderDate + ", street=" + street + ", city=" + city + ", state="
				+ state + ", book=" + book + ", quantity=" + quantity + ", extendedAmount=" + extendedAmount + "] from file: " + filename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getExtendedAmount() {
		return extendedAmount;
	}

	public void setExtendedAmount(BigDecimal extendedAmount) {
		this.extendedAmount = extendedAmount;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
