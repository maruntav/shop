package com.shop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.*;

public class TestBalanceCalculationNoOffers {
	Shop shop = null;
	
	@Before
	public void setUp() throws Exception{
		shop = new Shop();
	}
	
	@Test
	public void listAddedCorrectly(){
		String[] itemStrArr = {"Apple", "Orange", "Apple", "Orange"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(itemStrArr.length, items.size());
		for(int i = 0; i<items.size(); i++){
			assertEquals(itemStrArr[i], items.get(i).getName());
		}
	}
	
	@Test
	public void testBalanceCalculation(){
		BigDecimal balance = shop.findBalance(shop.itemStringToList(Arrays.asList(new String[]{"Apple", "Orange", "Apple", "Orange"})));
		assertEquals(1.7, balance.doubleValue(), 0.01);
	}
	
	@Test
	public void balanceShouldBe1p10(){
		BigDecimal balance = shop.findBalance(shop.itemStringToList(Arrays.asList(new String[]{"Apple", "Orange", "Orange"})));
		assertEquals(1.1, balance.doubleValue(), 0.01);
	}
	
	@Test
	public void balanceShouldBe2p55(){
		BigDecimal balance = shop.findBalance(shop.itemStringToList(Arrays.asList(new String[]{"Apple", "Orange", "Orange", "Apple", "Orange", "Apple"})));
		assertEquals(2.55, balance.doubleValue(), 0.01);
	}
}
