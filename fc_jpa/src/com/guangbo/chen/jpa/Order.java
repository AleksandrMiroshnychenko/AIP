package com.guangbo.chen.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.NamedQuery;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * this class is java Entity bean that is corresponds to the orders table
 * @author guangbo
 */
@NamedQueries({
	@NamedQuery(name = "order.getUniqueNum", query = "Select MAX(o.id) From Order o"),
	@NamedQuery(name = "order.viewOrder", query = "Select o From Order o Where o.orderNumber Like ?1 And o.surname Like ?2"),
	@NamedQuery(name = "order.findOutstandingOrders", query = "Select o From Order o Where o.status Like ?1 Or o.status Like ?2"),
	@NamedQuery(name = "order.findOrderByOrderNum", query = "Select o From Order o Where o.orderNumber Like ?1"),
	@NamedQuery(name = "order.findPaidOrders", query = "Select o From Order o Where o.status Like ?1"),
})
@Entity
@Table(name="orders", uniqueConstraints = { @UniqueConstraint(columnNames = "orderNumber")})
public class Order implements Serializable{
	
	private Integer id;
	private String orderNumber;
	private String title;
	private String surname;
	private String givenName;
	private String email;
	private String unitNumber;
	private String street;
	private String state;
	private String suburb;
	private String postCode;
	private String country;
	private String paymentDetails;
	private String status;
	private List<Orderline> orderlines;
	
	/**
	 * order constructor
	 */
	public Order() {
		super();
	}

	/**
	 * order constructor with all parameters
	 */
	public Order(String title, String surname, String givenName, String email,
			String unitNumber, String street, String state, String suburb,
			String postCode, String country, String paymentDetails) 
	{
		super();
		this.title = title;
		this.surname = surname;
		this.givenName = givenName;
		this.email = email;
		this.unitNumber = unitNumber;
		this.street = street;
		this.state = state;
		this.suburb = suburb;
		this.postCode = postCode;
		this.country = country;
		this.paymentDetails = paymentDetails;
	}

	/**
	 * @return the id
	 */
	@Id		
	@GeneratedValue(strategy=IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the orderNumber
	 */
	@Column(name = "orderNumber", unique = true, nullable = false, length = 20)
	public String getOrderNumber() {
		return orderNumber;
	}
	
	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	/**
	 * @return the title
	 */
	@Column(name = "title", unique = true, nullable = false, length = 10)
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the surname
	 */
	@Column(name = "surname", unique = true, nullable = false, length = 32)
	public String getSurname() {
		return surname;
	}
	
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * @return the givenName
	 */
	@Column(name = "givenName", unique = true, nullable = false, length = 32)
	public String getGivenName() {
		return givenName;
	}
	
	/**
	 * @param givenName the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	/**
	 * @return the email
	 */
	@Column(name = "email", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the unitNumber
	 */
	@Column(name = "unitNumber", unique = true, nullable = false, length = 10)
	public String getUnitNumber() {
		return unitNumber;
	}
	
	/**
	 * @param unitNumber the unitNumber to set
	 */
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	
	/**
	 * @return the street
	 */
	@Column(name = "street", unique = true, nullable = false, length = 32)
	public String getStreet() {
		return street;
	}
	
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * @return the state
	 */
	@Column(name = "state", unique = true, nullable = false, length = 32)
	public String getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the suburb
	 */
	@Column(name = "suburb", unique = true, nullable = false, length = 32)
	public String getSuburb() {
		return suburb;
	}
	
	/**
	 * @param suburb the suburb to set
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	
	/**
	 * @return the postCode
	 */
	@Column(name = "postCode", unique = true, nullable = false, length = 32)
	public String getPostCode() {
		return postCode;
	}
	
	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	/**
	 * @return the country
	 */
	@Column(name = "country", unique = true, nullable = false, length = 32)
	public String getCountry() {
		return country;
	}
	
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * @return the paymentDetails
	 */
	@Column(name = "paymentDetails", unique = true, nullable = false, length = 100)
	public String getPaymentDetails() {
		return paymentDetails;
	}
	
	/**
	 * @param paymentDetails the paymentDetails to set
	 */
	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	/**
	 * @return the status
	 */
	@Column(name = "status", unique = true, nullable = false, length = 7)
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
	public List<Orderline> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<Orderline> orderlines) {
		this.orderlines = orderlines;
	}

	/**
	 * this methods validate the customer order form
	 * @return true if is not empty, otherwise false
	 */
	public boolean formValidation(String title, String surname, String givenName, String email,
			String unitNumber, String street, String state, String suburb,
			String postCode, String country, String paymentDetails) 
	{
		if(title.equals("") || surname.equals("") || givenName.equals("") 
				|| email.equals("") || unitNumber.equals("") || street.equals("") 
				|| state.equals("") || suburb.equals("") || postCode.equals("") 
				|| country.equals("") || paymentDetails.equals(""))
		{
			return false;
		}
		else if(title.trim().isEmpty() || surname.trim().isEmpty() 
				|| givenName.trim().isEmpty() || email.trim().isEmpty()
				|| unitNumber.trim().isEmpty() || street.trim().isEmpty() 
				|| state.trim().isEmpty() || suburb.trim().isEmpty()
				|| postCode.trim().isEmpty() || country.trim().isEmpty() 
				|| paymentDetails.trim().isEmpty())
		{
			return false;
		}
		return true;
	}
 
}
