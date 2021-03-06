package com.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Shop 
{
    public static void main( String[] args )
    {
    	Shop shop = new Shop();
    	String[] itemStrArr = {"Apple", "Orange", "Apple", "Orange"};
		List<Item> items = shop.itemStringToList(Arrays.asList(itemStrArr));
		double balance = shop.findBalance(items).doubleValue();
		System.out.println(balance);
    }
    
    public List<Item> itemStringToList(List<String> itemsStr){
    	List<Item> items = new ArrayList<Item>();
    	for(String i : itemsStr){
    		items.add(i.equals("Apple")?new Apple():new Orange());
    	}
    	return items;
    }
    
    public BigDecimal findBalance(List<Item> items){
    	return buyOneGetOneFree(items).add(threeForTwo(items));
    }
    
    public int getItemCount(List<Item> items, Class<?> cl){
    	int count = 0;
    	for(Item item : items){
    		if(cl==Apple.class){
    			if(item.getName().equals("Apple")) count++; //could check instance of item
    		}
    		else if(cl==Orange.class){
    			if(item.getName().equals("Orange")) count++;
    		}
    	}
    	return count;
    }
    
    public BigDecimal threeForTwo(List<Item> items){
    	int count = getItemCount(items, Orange.class);
    	int remainder = count%3;
    	int offerCount = (count-remainder)/3;
    	int countAfterOffer = (2*offerCount)+remainder;
    	double balance = countAfterOffer*0.25;
    	return new BigDecimal(balance);
    }
    
    public BigDecimal buyOneGetOneFree(List<Item> items){
    	int count = getItemCount(items, Apple.class);
    	int remainder = count%2;
    	int offerCount = (count-remainder)/2;
    	int countAfterOffer = offerCount+remainder;
    	double balance = countAfterOffer*0.6;
    	return new BigDecimal(balance);
    }
}
