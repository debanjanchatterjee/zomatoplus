package com.thinkxfactor.zomatoplus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Item;
import com.thinkxfactor.zomatoplus.models.RestItemPair;
import com.thinkxfactor.zomatoplus.models.Restaurant;
import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.ItemRepository;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;
import com.thinkxfactor.zomatoplus.repository.UserRepository;

// A RESTful controller

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	@PostMapping("/add")
	public Restaurant addUser(@RequestBody Restaurant restaurant) {
		// takes restaurant object from client
		Restaurant persistedRestaurant = restaurantRepository.save(restaurant); 
		// line above saves the object in database
		// and returns same Restaurant object with id value updated as in DB  
		return persistedRestaurant;
	}
	
	@GetMapping("/getAll")
	public List<Restaurant> getAll() {
		List <Restaurant> list_of_restaurants = restaurantRepository.findAll();
		return list_of_restaurants;
	}
	
	@PostMapping("/addItem")
	public Item addItem(@RequestBody Item item) {
		Item persistedItem = itemRepository.save(item);
		return persistedItem;
	}
	
	@GetMapping("/getAllItem")
	public List<Item> getAllItem() {
		List <Item> list_of_items = itemRepository.findAll();
		return list_of_items;
	}
	
	
	
	@PostMapping("/create")
	public Restaurant restaurantCreate(@RequestBody Restaurant restaurant) {
		System.out.println(restaurant.toString());
		//restaurants.add(restaurant);
		return restaurant;
	}
	
	@GetMapping("/getall1")
	public List<Restaurant> restaurantList() {
		List<Restaurant> restaurants = new ArrayList<>();

		restaurants.add(new Restaurant(1,"sd","d","ds",23,32,"asd"));
		return restaurants;
	}
//	
//	@PostMapping("/additems")
//
//	public Item addItem(@RequestBody Item item)
//	{
//		System.out.println(item.toString());
//		return item;
//	}
//	
	
	
	
//	public Item restaurantAdd(@RequestBody RestItemPair rest_item) throws IOException {
//	Restaurant restaurant = rest_item.getRestaurant();
//	Item item = rest_item.getItem();
//	System.out.println(restaurant.toString());
//	System.out.println(item.toString());
//	if(!restaurants.contains(restaurant)) 
//		restaurants.add(restaurant);
//	else 
//		restaurant = restaurants.get(restaurants.indexOf(restaurant));
//	List<Item> items = restaurant.getItems();
//	items.add(item);
//	restaurant.setItems(items);
//	return item;
//}
	
}
