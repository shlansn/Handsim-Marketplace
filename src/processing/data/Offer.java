package processing.data;

import java.util.Date;

public class Offer {
	private String offerID;
	private double price;
	private String amountOfTimeNeeded;
	private String status;
	private Company company;
	private Date date;
	private String description;
	
	public Offer() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Getters and Setters
	 */
	public String getOfferID() {
		return offerID;
	}

	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAmountOfTimeNeeded() {
		return amountOfTimeNeeded;
	}

	public void setAmountOfTimeNeeded(String amountOfTimeNeeded) {
		this.amountOfTimeNeeded = amountOfTimeNeeded;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
