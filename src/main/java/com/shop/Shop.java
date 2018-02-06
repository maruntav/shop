package com.shop;

import java.math.BigDecimal;
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
}
