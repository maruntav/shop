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
    		if(cl==Apple.class){
    			if(item.getName().equals("Apple")) count++;
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
    	int countAfterOffer = (2*offerCount)+1;
    	double balance = countAfterOffer*0.25;
    	return new BigDecimal(balance);
    }
    
    public BigDecimal buyOneGetOneFree(List<Item> items){
    	int count = getItemCount(items, Apple.class);
    	int remainder = count%3;
    	int offerCount = (count-remainder)/2;
    	int countAfterOffer = offerCount+1;
    	double balance = countAfterOffer*0.6;
    	return new BigDecimal(balance);
    }
}
