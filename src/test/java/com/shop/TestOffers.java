package com.shop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
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
	
	public void threeForTwo(){
		String[] itemStrArr = {"Orange", "Orange", "Orange", "Orange"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(0.75, shop.threeForTwo(items).doubleValue(), 0.01);
	}
	
	public void threeForTwoN2(){
		String[] itemStrArr = {"Orange", "Orange", "Orange", "Orange", "Apple", "Orange", "Apple"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(1.0, shop.threeForTwo(items).doubleValue(), 0.01);
	}
	
	public void threeForTwoN3(){
		String[] itemStrArr = {"Orange", "Orange", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(1.0, shop.threeForTwo(items).doubleValue(), 0.01);
	}
	
	public void buyOneGetOneFree(){
		String[] itemStrArr = {"Apple", "Apple", "Apple", "Apple", "Apple"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(1.8, shop.threeForTwo(items).doubleValue(), 0.01);
	}
	
	public void buyOneGetOneFreeN2(){
		String[] itemStrArr = {"Apple", "Orange", "Apple", "Apple", "Orange"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(1.2, shop.threeForTwo(items).doubleValue(), 0.01);
	}
	
	public void buyOneGetOneFreeN3(){
		String[] itemStrArr = {"Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Apple"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(1.8, shop.threeForTwo(items).doubleValue(), 0.01);
	}
	
	public void testOffer1(){
		String[] itemStrArr = {"Apple", "Apple", "Orange", "Orange", "Orange"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(1.7, shop.findBalance(items));
	}
}
