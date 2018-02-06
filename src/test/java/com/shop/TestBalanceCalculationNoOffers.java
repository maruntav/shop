package com.shop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.*;

public class TestBalanceCalculationNoOffers {
	Shop shop = null;
	
	@Before
	public void setUp() throws Exception{
		shop = new Shop();
	}
	@Test
	public void listAddedCorrectly(){
		String[] itemStrArr = {"Apple, Orange", "Apple", "Orange"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		assertEquals(itemStrArr.length, items.size());
		for(int i = 0; i<items.size(); i++){
			assertEquals(itemStrArr[i], items.get(i).getName());
		}
	}
}
