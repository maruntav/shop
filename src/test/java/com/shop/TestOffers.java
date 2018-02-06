package com.shop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

public class TestOffers {
	Shop shop = null;
	
	@Before
	public void setUp() throws Exception{
		shop = new Shop();
	}
	
	@Test
	public void itemCountCorrect(){
		String[] itemStrArr = {"Apple", "Orange", "Apple", "Orange", "Apple"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(3, shop.getItemCount(items, Apple.class));
	}
	
	@Test
	public void fiveApples(){
		String[] itemStrArr = {"Apple", "Orange", "Apple", "Orange", "Apple", "Apple", "Apple"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(5, shop.getItemCount(items, Apple.class));
	}
	
	@Test
	public void twoOranges(){
		String[] itemStrArr = {"Apple", "Orange", "Apple", "Orange", "Apple", "Apple", "Apple"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(2, shop.getItemCount(items, Orange.class));
	}
	
	@Test
	public void noOranges(){
		String[] itemStrArr = {"Apple", "Apple", "Apple", "Apple", "Apple"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(0, shop.getItemCount(items, Orange.class));
	}
	
	@Test
	public void noApples(){
		String[] itemStrArr = {"Orange", "Orange", "Orange", "Orange"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(0, shop.getItemCount(items, Apple.class));
	}
}
