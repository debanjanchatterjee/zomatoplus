package com.thinkxfactor.zomatoplus.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_restaurant")
public class Restaurant implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "restaurant_id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "contact")
	private long contact;
	
	@Column(name = "likeCount")
	private int likeCount;
	
	@Column(name = "description")
	private String description;
	
	//List <Item> items = new ArrayList<>();
	
	public Restaurant() {}

	public Restaurant(long id, String name, String address, String website, long contact, int likeCount,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.website = website;
		this.contact = contact;
		this.likeCount = likeCount;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	


		
}
