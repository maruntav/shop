package com.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Shop 
{
    public static void main( String[] args )
    {
        
    }
    
    public List<Item> itemStringToList(List<String> itemsStr){
    	List<Item> items = new ArrayList<Item>();
    	for(String i : itemsStr){
    		items.add(i.equals("Apple")?new Apple():new Orange());
    	}
    	return items;
    }
    
    public BigDecimal findBalance(List<Item> items){
    	BigDecimal balance = new BigDecimal(0.00);
    	for(Item item : items){
    		balance = balance.add(item.getPrice());
    	}
    	return balance;
    }
    
    public int getItemCount(List<Item> items, Class<?> cl){
    	int count = 0;
    	for(Item item : items){
    		if(cl==Apple.class) if(item.getName().equals("Apple")) count++;
    		else if(cl==Orange.class) if(item.getName().equals("Orange")) count++;
    	}
    	return count;
    }
}
