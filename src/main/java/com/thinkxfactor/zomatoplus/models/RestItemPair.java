package com.thinkxfactor.zomatoplus.models;

public class RestItemPair {
	Restaurant restaurant;
	Item item;
	public RestItemPair() {}
	public RestItemPair(Restaurant restaurant, Item item) {
		super();
		this.restaurant = restaurant;
		this.item = item;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
