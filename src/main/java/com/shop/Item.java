package com.shop;

import java.math.BigDecimal;

abstract class Item {
	protected String name;
	protected BigDecimal price;
	
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
}
