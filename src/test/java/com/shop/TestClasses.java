package com.shop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestClasses {
	Item apple = null;
	Item orange = null;
	
	@Before
	public void setUp() throws Exception{
		apple = new Apple();
		orange = new Orange();
	}
	
	@Test
	public void checkNames(){
		assertEquals("Apple", apple.getName());
		assertEquals("Orange", orange.getName());
	}
}