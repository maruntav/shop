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
}
